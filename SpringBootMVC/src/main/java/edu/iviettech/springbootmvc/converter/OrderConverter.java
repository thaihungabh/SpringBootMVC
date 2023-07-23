package edu.iviettech.springbootmvc.converter;

import edu.iviettech.springbootmvc.entity.OrderDetailEntity;
import edu.iviettech.springbootmvc.entity.OrderEntity;
import edu.iviettech.springbootmvc.model.Order;

public class OrderConverter {
    public static Order transferToModel(OrderEntity entity){
        Order model = new Order();
        model.setId(entity.getId());
        model.setOrderDate(entity.getOrderDate());
        model.setCustomerName(entity.getCustomerName());
        model.setCustomerAddress(entity.getCustomerAddress());
        model.setOrderDetails(entity.getOrderDetails());
        return model;
    }
    public static OrderEntity transferToEntity(Order model){
        OrderEntity entity = new OrderEntity();
        entity.setOrderDate(model.getOrderDate());
        entity.setCustomerName(model.getCustomerName());
        entity.setCustomerAddress(model.getCustomerAddress());
        return entity;
    }
}
