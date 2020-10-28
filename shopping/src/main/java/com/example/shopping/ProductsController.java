package com.example.shopping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.models.Product;


@Controller
public class ProductsController {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@GetMapping("/api/products") 
	public ResponseEntity<List<Product>> getTodos() {
		//	all products
		return ResponseEntity.ok(null);
	}
	
	
		
}
