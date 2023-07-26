package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "samsung s20 ultra", 200, "good", "Samsung"));
        productList.add(new Product(2, "iphone Xs Max", 300, "good", "Apple"));
        productList.add(new Product(3, "Macbook air 2020", 1000, "good", "Apple"));
    }


    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public boolean save(Product product) {
        return productList.add(product);
    }

    @Override
    public boolean update(int id,Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == product.getId()) {
                productList.set(i,product);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return productList.remove(product);
            }
        }
        return false;
    }

    @Override
    public Product findById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public Product findByName(String name) {
        for (Product product : productList) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }
}
