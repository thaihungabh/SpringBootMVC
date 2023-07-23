package edu.iviettech.springbootmvc.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "order_date")
    private LocalDateTime orderDate;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "customer_address")
    private String customerAddress;
    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    List<OrderDetailEntity> orderDetails;
}
