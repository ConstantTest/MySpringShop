package com.alex.spring.dao.model;

import java.util.Map;

/**
 * Created by Alex on 25.04.2018.
 */
public class Order {
    private Long id;
    private User user;
    private Map<Product, Integer> products;

    public Order(Long id, User user, Map<Product, Integer> products) {
        this.id = id;
        this.user = user;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }
}
