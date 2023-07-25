package edu.iviettech.springbootmvc.service.impl;

import edu.iviettech.springbootmvc.converter.OrderConverter;
import edu.iviettech.springbootmvc.converter.OrderDetailConverter;
import edu.iviettech.springbootmvc.entity.OrderDetailEntity;
import edu.iviettech.springbootmvc.entity.OrderEntity;
import edu.iviettech.springbootmvc.model.Order;
import edu.iviettech.springbootmvc.model.OrderDetail;
import edu.iviettech.springbootmvc.repository.OrderDetailRepository;
import edu.iviettech.springbootmvc.repository.OrderRepository;
import edu.iviettech.springbootmvc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Transactional
    @Override
    public void saveOrderWithOrderDetail(Order order, List<OrderDetail> orderDetails) {
        OrderEntity newOrder = orderRepository.save(OrderConverter.transferToEntity(order));

        orderDetails.stream().forEach(detail->{
            detail.setOrder(OrderConverter.transferToModel(newOrder));
        });
        List<OrderDetailEntity> listDetailEntities = orderDetails.stream()
                                                                    .map(OrderDetailConverter::trasferToEntity)
                                                                    .toList();

        listDetailEntities.stream().forEach(detail->{
            orderDetailRepository.save(detail);
        });
    }

    @Override
    public List<Order> getAllOrder() {
        List<OrderEntity> orderEntities = orderRepository.findAll();
        return orderEntities.stream().map(OrderConverter::transferToModel).collect(Collectors.toList());
    }

    @Override
    public List<OrderDetail> getOrderDetailByOrder(Long id) {
        List<OrderDetailEntity> orderDetailEntities = orderRepository.findById(id).get().getOrderDetails();
        return orderDetailEntities.stream().map(OrderDetailConverter::transferToModel).collect(Collectors.toList());
    }
}
