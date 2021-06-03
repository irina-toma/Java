package com.link.auto.dao.impl;

import com.link.auto.dao.Product;
import com.link.auto.dao.ProductDAO;
import com.link.auto.dao.ProductRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Product> getAll() {
        // luam din baza de date produsele
        String sql = "SELECT * FROM `auto`.`product`";
        List<Product> productList = jdbcTemplate.query(sql, new ProductRowMapper());
        return productList;
    }

    @Override
    public Product getById(Integer id) {
        // query in baza de date care sa imi identifice serviciul
        // cu id-ul id
        String query = "SELECT * FROM `auto`.`product` WHERE id=" + id;
        // intoarce un singur element
        Product product = jdbcTemplate.queryForObject(query, new ProductRowMapper());
        return product;
    }
}
