package com.alex.spring.services.converters;

import com.alex.spring.dao.model.Order;
import com.alex.spring.services.dto.OrderDto;

/**
 * Created by Alex on 24.04.2018.
 */
public interface OrderConverter {
    Order toEntity(OrderDto dto);
    OrderDto toDto(Order o);
}
