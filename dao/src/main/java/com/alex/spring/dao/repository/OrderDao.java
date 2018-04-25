package com.alex.spring.dao.repository;

import com.alex.spring.dao.model.Order;

import java.util.List;

/**
 * Created by Alex on 24.04.2018.
 */
public interface OrderDao {
    void confirm(Order order);
    List<Order> findAll();
}
