package com.link.auto.dao.impl;

import com.link.auto.dao.Product;
import com.link.auto.dao.ProductDAO;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Product> getAll() {
        // luam din baza de date produsele
        String sql = "SELECT * FROM `auto`.`product`";
        Query query = entityManager.createNativeQuery(sql, Product.class);
        return query.getResultList();
    }

    @Override
    public Product getById(Integer id) {
        return entityManager.find(Product.class, id);
    }
}
