package com.alex.spring.services.dto;

import com.alex.spring.dao.model.Product;
import com.alex.spring.dao.model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 24.04.2018.
 */
public class OrderDto {
    private String userId;
    private String userFirstName;
    private String userLastName;
    private Map<String, String> productDtos;
    private Map<ProductDto, Integer> products;

    public OrderDto(String userId, String productId, String count) {
        this.userId = userId;
        productDtos = new HashMap<String, String>();
        productDtos.put(productId, count);
    }

    public OrderDto(String userId, Map<String, String> map) {
        this.userId = userId;
        this.productDtos = map;
    }

    public OrderDto(String userId, String userFirstName, String userLastName, Map<ProductDto, Integer> map) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.products = map;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public Map<String, String> getProductDtos() {
        return productDtos;
    }

    public void setProductDtos(Map<String, String> productDtos) {
        this.productDtos = productDtos;
    }

    public Map<ProductDto, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<ProductDto, Integer> products) {
        this.products = products;
    }
}
