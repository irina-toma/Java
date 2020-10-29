package com.example.shopping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.models.Product;
import com.example.models.ProductMapper;


@Controller
public class ProductsController {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@GetMapping("/products") 
	public ModelAndView getProductView() {
		ModelAndView view = new ModelAndView("products.html");
		return view;
	}
	
	@GetMapping("/api/products") 
	public ResponseEntity<List<Product>> getProducts() {
		//	all products
		List<Product> productList = jdbcTemplate.query("SELECT * FROM products", new ProductMapper());
		
		return ResponseEntity.ok(productList);
	}
		
}
