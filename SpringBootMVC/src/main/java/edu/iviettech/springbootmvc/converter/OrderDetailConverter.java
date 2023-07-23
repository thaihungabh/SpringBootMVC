package edu.iviettech.springbootmvc.converter;

import edu.iviettech.springbootmvc.entity.OrderDetailEntity;
import edu.iviettech.springbootmvc.model.OrderDetail;

public class OrderDetailConverter {
    public static OrderDetailEntity trasferToEntity(OrderDetail model){
        OrderDetailEntity entity = new OrderDetailEntity();
        entity.setOrder(OrderConverter.transferToEntity(model.getOrder()));
        entity.setProduct(ProductConverter.transferToEntity(model.getProduct()));
        entity.setQuantity(model.getQuantity());
        return entity;
    }
    public static OrderDetail transferToModel(OrderDetailEntity entity){
        OrderDetail model = new OrderDetail();
        model.setId(entity.getId());
        model.setOrder(OrderConverter.transferToModel(entity.getOrder()));
        model.setProduct(ProductConverter.transferToModel(entity.getProduct()));
        model.setQuantity(entity.getQuantity());
        return model;
    }
}
