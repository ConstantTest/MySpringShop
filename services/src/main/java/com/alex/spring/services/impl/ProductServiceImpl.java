package com.alex.spring.services.impl;

import com.alex.spring.dao.model.Product;
import com.alex.spring.dao.repository.ProductDao;
import com.alex.spring.services.ProductService;
import com.alex.spring.services.converters.ProductConverter;
import com.alex.spring.services.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 24.04.2018.
 */
@Service
public class ProductServiceImpl implements ProductService {
    private ProductDao productDao;
    private ProductConverter converter;

    @Autowired
    public ProductServiceImpl(ProductDao dao, ProductConverter converter) {
        productDao = dao;
        this.converter = converter;
    }

    @Override
    public void create(ProductDto productDto) {
        productDao.create(converter.toEntity(productDto));
    }

    @Override
    public List<ProductDto> findAll() {
        List<Product> products = productDao.findAll();
        List<ProductDto> productDtos = new ArrayList<ProductDto>();
        for (Product p: products) {
            productDtos.add(converter.toDto(p));
        }
        return productDtos;
    }
}
