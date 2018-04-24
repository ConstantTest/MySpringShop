package com.alex.spring.services;

import com.alex.spring.dao.model.Product;
import com.alex.spring.services.dto.ProductDto;

import java.util.List;

/**
 * Created by Alex on 24.04.2018.
 */
public interface ProductService {
    void create(ProductDto productDto);
    List<ProductDto> findAll();
}
