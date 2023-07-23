package edu.iviettech.springbootmvc.model;

import edu.iviettech.springbootmvc.entity.OrderDetailEntity;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Order {
    private Long id;
    private LocalDateTime orderDate = LocalDateTime.now();
    private String customerName;
    private String customerAddress;
    List<OrderDetailEntity> orderDetails;
}
