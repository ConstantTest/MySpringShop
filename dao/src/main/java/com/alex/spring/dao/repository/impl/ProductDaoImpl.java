package com.alex.spring.dao.repository.impl;

import com.alex.spring.dao.model.Product;
import com.alex.spring.dao.repository.ProductDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex on 24.04.2018.
 */
@Repository
public class ProductDaoImpl implements ProductDao {
    private Map<Long, Product> products = new HashMap<Long, Product>();
    private static volatile Long idGenerator = 1L;

    @Override
    public void create(Product product) {
        product.setId(idGenerator++);
        products.put(product.getId(), product);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<Product>(products.values());
    }

    @Override
    public Product getProductById(Long id) {
        return products.get(id);
    }
}
