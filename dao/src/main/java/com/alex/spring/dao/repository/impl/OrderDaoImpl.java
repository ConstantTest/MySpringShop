package com.alex.spring.dao.repository.impl;

import com.alex.spring.dao.model.Order;
import com.alex.spring.dao.repository.OrderDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex on 24.04.2018.
 */
@Repository
public class OrderDaoImpl implements OrderDao {
    private Map<Long, Order> orders = new HashMap<Long, Order>();
    private static volatile Long idGenerator = 1L;

    @Override
    public void confirm(Order order) {
        order.setId(idGenerator++);
        orders.put(order.getId(), order);
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<Order>(orders.values());
    }
}
