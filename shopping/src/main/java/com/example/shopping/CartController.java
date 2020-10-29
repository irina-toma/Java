package com.example.shopping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.models.Order;
import com.example.models.Product;
import com.example.models.ProductMapper;
import com.example.models.User;
import com.example.models.UserMapper;

@Controller
public class CartController {

	static final String PENDING = "PENDING"; // inca nu a cumparat
	static final String PROGRES = "PROGRES"; // a cumparat, dar nu e procesata
	static final String COURIER = "COURIER"; // a fost predata curierului
	static final String FINISHED = "FINISHED"; // primita de client

	@Autowired
	JdbcTemplate jdbcTemplate;

	@GetMapping("/cart")
	public ModelAndView getCartPage() {
		return new ModelAndView("cart.html");
	}
	
	@GetMapping("/api/cart") 
	public ResponseEntity<List<Product>> getProducts(
			@CookieValue(name = "username") String username) {
		//	all products for user id

		int userId = this.getAuthUserId(username);
		if (userId == -1) {
			return ResponseEntity.badRequest().build();
		}
		
		List<Product> products = jdbcTemplate.query("SELECT p.id, p.name, up.quantity, "
				+ "p.price FROM user_products as up, products as p " + 
				"WHERE up.user_id=" + userId + " AND up.status =\"PENDING\" "
				+ "AND up.product_id = p.id;", new ProductMapper());

		return ResponseEntity.ok(products);
	}

	@PostMapping(value="/api/cart")
	public ResponseEntity<Product> addProduct(@RequestBody Order order, 
			@CookieValue(name = "username") String username) {
		//	add product to cart

		// product id -> din url
		// identificam user -> din cookie	
		int userId = this.getAuthUserId(username);
		if (userId == -1) {
			return ResponseEntity.badRequest().build();
		}

		// adaugam in baza de date
		int result = jdbcTemplate.update("INSERT INTO user_products VALUES (?, ?, ?, ?)",
				userId, order.getProductId(), order.getQuantity(), "PENDING");

		if (result != 1) {
			System.out.println("Nu a reusit update-ul");
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(null);
	}

	private int getAuthUserId(String username) {
		List<User> userList = jdbcTemplate.query("SELECT * FROM users WHERE username=\"" 
				+ username + "\"", new UserMapper());
		
		if (userList.size() != 1) {
			return -1;
		} 

		int userId = userList.get(0).getId();
		return userId;
	}

}
