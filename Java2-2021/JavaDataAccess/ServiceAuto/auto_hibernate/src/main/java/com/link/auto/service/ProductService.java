package com.link.auto.service;

import com.link.auto.dao.Product;
import com.link.auto.dao.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductDAO productDAO;

    public List<Product> getAll() {
        List<Product> productList = productDAO.getAll();
        return productList;
    }

    public Product getById(Integer id) {
        Product product = productDAO.getById(id);
        return product;
    }
}
