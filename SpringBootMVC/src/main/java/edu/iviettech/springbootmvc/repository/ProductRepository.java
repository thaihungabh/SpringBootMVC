package edu.iviettech.springbootmvc.repository;

import edu.iviettech.springbootmvc.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
}
