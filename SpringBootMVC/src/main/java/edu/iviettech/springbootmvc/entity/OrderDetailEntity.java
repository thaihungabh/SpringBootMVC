package edu.iviettech.springbootmvc.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "orderdetails")
@Data
public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "order_entity_id")
    OrderEntity order;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "product_entity_id")
    ProductEntity product;
    private Integer quantity;
}
