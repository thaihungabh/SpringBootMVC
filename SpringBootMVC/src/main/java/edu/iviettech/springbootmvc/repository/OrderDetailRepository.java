package edu.iviettech.springbootmvc.repository;

import edu.iviettech.springbootmvc.entity.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity,Long> {
}
