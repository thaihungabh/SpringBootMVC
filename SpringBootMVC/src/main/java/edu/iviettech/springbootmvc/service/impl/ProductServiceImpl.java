package edu.iviettech.springbootmvc.service.impl;

import edu.iviettech.springbootmvc.converter.ProductConverter;
import edu.iviettech.springbootmvc.entity.ProductEntity;
import edu.iviettech.springbootmvc.model.Product;
import edu.iviettech.springbootmvc.repository.ProductRepository;
import edu.iviettech.springbootmvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product getProductById(Long id) {
        return ProductConverter.transferToModel(productRepository.findById(id).orElse(null));
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(ProductConverter.transferToEntity(product));
    }

    @Override
    public List<Product> getAllProduct() {
        List<ProductEntity> productEntities = productRepository.findAll();
        return productEntities.stream()
                .map(ProductConverter::transferToModel)
                .collect(Collectors.toList());
    }
}
