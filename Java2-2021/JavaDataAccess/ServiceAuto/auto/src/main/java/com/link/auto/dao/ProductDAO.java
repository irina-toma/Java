package com.link.auto.dao;

import java.util.List;

public interface ProductDAO {
    List<Product> getAll();
    Product getById(Integer id);
}
