package com.alex.spring.services;

import com.alex.spring.services.dto.OrderDto;

import java.util.List;

/**
 * Created by Alex on 24.04.2018.
 */
public interface OrderService {
    void confirm(OrderDto orderDto);
    List<OrderDto> findAll();
}
