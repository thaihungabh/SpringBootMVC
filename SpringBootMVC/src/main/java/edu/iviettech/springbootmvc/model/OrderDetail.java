package edu.iviettech.springbootmvc.model;

import lombok.Data;

@Data
public class OrderDetail {
    private Long id;
    private Order order;
    private Product product;
    private Integer quantity;
}
