package edu.iviettech.springbootmvc.converter;

import edu.iviettech.springbootmvc.entity.ProductEntity;
import edu.iviettech.springbootmvc.model.Product;

public class ProductConverter {
    public static ProductEntity transferToEntity(Product product){
        ProductEntity entity = new ProductEntity();
        entity.setName(product.getName());
        entity.setDescription(product.getDescription());
        entity.setUnitPrice(product.getUnitPrice());
        return entity;
    }
    public static Product transferToModel(ProductEntity productEntity){
        Product model = new Product();
        model.setId(productEntity.getId());
        model.setName(productEntity.getName());
        model.setDescription(productEntity.getDescription());
        model.setUnitPrice(productEntity.getUnitPrice());
        return model;
    }
}
