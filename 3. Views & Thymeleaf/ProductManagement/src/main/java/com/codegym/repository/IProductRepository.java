package com.codegym.repository;

import com.codegym.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    boolean save(Product product);

    boolean update(int id,Product product);

    boolean delete(int id);

    Product findById(int id);

    Product findByName(String name);
}
