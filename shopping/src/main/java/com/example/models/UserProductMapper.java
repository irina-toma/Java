package com.example.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserProductMapper implements RowMapper<UserProduct>{

	@Override
	public UserProduct mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserProduct userProduct = new UserProduct(rs.getInt("id"), rs.getInt("userId"), 
				rs.getInt("productId"), rs.getInt("quantity"), rs.getString("state"));
		return userProduct;
	}

}
