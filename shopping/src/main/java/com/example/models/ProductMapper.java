package com.example.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductMapper implements RowMapper<Product>{

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product(rs.getInt("id"), rs.getString("name"), 
				rs.getInt("quantity"), rs.getDouble("price"));
		return product;
	}

}
