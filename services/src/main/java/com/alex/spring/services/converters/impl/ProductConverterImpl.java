package com.alex.spring.services.converters.impl;

import com.alex.spring.dao.model.Product;
import com.alex.spring.services.converters.ProductConverter;
import com.alex.spring.services.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by Alex on 24.04.2018.
 */
@Component
public class ProductConverterImpl implements ProductConverter {
    @Override
    public Product toEntity(ProductDto dto) {
        return new Product(
                null,
                dto.getName(),
                new BigDecimal(dto.getPrice()),
                Product.Size.valueOf(dto.getSize()),
                Product.Color.valueOf(dto.getColor()),
                Product.Gender.valueOf(dto.getGender())
        );
    }

    @Override
    public ProductDto toDto(Product entity) {
        return new ProductDto(
                entity.getName(),
                entity.getPrice().toString(),
                entity.getSize().name(),
                entity.getColor().name(),
                entity.getGender().name()
        );
    }
}
