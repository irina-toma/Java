package com.example.shopping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.models.Product;

@Controller
public class CartController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@GetMapping("/api/cart/users/{id}") 
	public ResponseEntity<List<Product>> getTodos(@PathVariable("id") int id) {
		//	all products for user id
		return ResponseEntity.ok(null);
	}

	@PostMapping(value="/api/cart/users/{id}")
	public ResponseEntity<Product> createTodo(@PathVariable("id") int id, @RequestBody Product product) {
		//	add product to cart
		return ResponseEntity.ok(null);
	}

}
