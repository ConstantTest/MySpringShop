package com.alex.spring.services.converters;

import com.alex.spring.dao.model.Product;
import com.alex.spring.services.dto.ProductDto;

/**
 * Created by Alex on 24.04.2018.
 */
public interface ProductConverter {
    Product toEntity(ProductDto dto);
    ProductDto toDto(Product entity);
}
