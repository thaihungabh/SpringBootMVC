package edu.iviettech.springbootmvc.repository;

import edu.iviettech.springbootmvc.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OrderRepository extends JpaRepository<OrderEntity,Long> {
}
