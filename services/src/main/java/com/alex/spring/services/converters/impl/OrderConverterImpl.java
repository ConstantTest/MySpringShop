package com.alex.spring.services.converters.impl;

import com.alex.spring.dao.model.Order;
import com.alex.spring.dao.model.Product;
import com.alex.spring.dao.repository.ProductDao;
import com.alex.spring.dao.repository.UserDao;
import com.alex.spring.services.converters.OrderConverter;
import com.alex.spring.services.dto.OrderDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex on 24.04.2018.
 */
@Component
public class OrderConverterImpl implements OrderConverter {
    private UserDao userDao;
    private ProductDao productDao;

    @Autowired
    public OrderConverterImpl(UserDao userDao, ProductDao productDao) {
        this.userDao = userDao;
        this.productDao = productDao;
    }

    @Override
    public Order toEntity(OrderDto dto) {
        Map<Product, Integer> products = new HashMap<Product, Integer>();
        Map<String, String> productsDtos = dto.getProductDtos();
        for (Map.Entry<String, String> entry: productsDtos.entrySet()) {
            products.put(productDao.getProductById(Long.valueOf(entry.getKey())),
                    Integer.parseInt(entry.getValue()));
        }
        return new Order(
                null,
                userDao.findUserById(Long.valueOf(dto.getUserId())),
                products
        );
    }

    @Override
    public OrderDto toDto(Order o) {
        Map<String, String> productDtos = new HashMap<String, String>();
        Map<Product, Integer> products = o.getProducts();
        for (Map.Entry<Product, Integer> entry: products.entrySet()) {
            productDtos.put(
                    String.valueOf(entry.getKey().getId()),
                    String.valueOf(entry.getValue())
            );
        }
        return new OrderDto(
                String.valueOf(o.getUser().getId()),
                productDtos
        );
    }
}
