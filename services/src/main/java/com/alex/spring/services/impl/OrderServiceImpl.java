package com.alex.spring.services.impl;

import com.alex.spring.dao.model.Order;
import com.alex.spring.dao.model.Product;
import com.alex.spring.dao.repository.OrderDao;
import com.alex.spring.services.OrderService;
import com.alex.spring.services.converters.OrderConverter;
import com.alex.spring.services.converters.ProductConverter;
import com.alex.spring.services.dto.OrderDto;
import com.alex.spring.services.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex on 24.04.2018.
 */
@Service
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;
    private OrderConverter converter;
    private ProductConverter productConverter;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao, OrderConverter converter, ProductConverter productConverter) {
        this.orderDao = orderDao;
        this.converter = converter;
        this.productConverter = productConverter;
    }

    @Override
    public void confirm(OrderDto orderDto) {
        orderDao.confirm(converter.toEntity(orderDto));
    }

    @Override
    public List<OrderDto> findAll() {
        List<Order> orders = orderDao.findAll();
        List<OrderDto> orderDtos = new ArrayList<OrderDto>();
        for (Order o: orders) {
            Map<Product, Integer> products = o.getProducts();
            Map<ProductDto, Integer> productDtos = new HashMap<ProductDto, Integer>();
            for (Map.Entry<Product, Integer> entry: products.entrySet()) {
                productDtos.put(productConverter.toDto(entry.getKey()), entry.getValue());
            }
            orderDtos.add(new OrderDto(
                    String.valueOf(o.getId()),
                    o.getUser().getFirstName(),
                    o.getUser().getLastName(),
                    productDtos));
        }
        return orderDtos;
    }

//    @Override
//    public List<OrderDto> findAll() {
//        List<Order> orders = orderDao.findAll();
//        List<OrderDto> orderDtos = new ArrayList<OrderDto>();
//        for (Order o: orders) {
//            Map<Product, Integer> products = o.getProducts();
//            Map<String, String> productDtos = new HashMap<String, String>();
//            for (Map.Entry<Product, Integer> entry: products.entrySet()) {
//                productDtos.put(String.valueOf(entry.getKey().getId()), String.valueOf(entry.getValue()));
//            }
//            orderDtos.add(new OrderDto(String.valueOf(o.getUser().getId()), productDtos));
//        }
//        return orderDtos;
//    }


}
