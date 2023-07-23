package edu.iviettech.springbootmvc.service;

import edu.iviettech.springbootmvc.model.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id);
    void createProduct(Product product);
    List<Product> getAllProduct();
}
