package edu.iviettech.springbootmvc.service;

import edu.iviettech.springbootmvc.model.Order;
import edu.iviettech.springbootmvc.model.OrderDetail;

import java.util.List;

public interface OrderService {
    void saveOrderWithOrderDetail(Order order, List<OrderDetail> orderDetails);
    List<Order> getAllOrder();
    List<OrderDetail> getOrderDetailByOrder(Long id);
}
