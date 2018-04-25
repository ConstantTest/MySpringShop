package com.alex.spring.dao.repository;

import com.alex.spring.dao.model.Product;

import java.util.List;

/**
 * Created by Alex on 24.04.2018.
 */
public interface ProductDao {
    void create(Product product);
    List<Product> findAll();
    Product getProductById(Long id);
}
