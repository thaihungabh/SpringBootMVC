package edu.iviettech.springbootmvc.model;

import edu.iviettech.springbootmvc.entity.OrderDetailEntity;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.List;

@Data
public class Product {
    private Long id;

    @NotBlank //K dc empty,null and space
    private String name;

    @NotBlank
    private String description;

    @Digits(integer = 6, fraction = 3)
    @DecimalMin(value = "0.0")
    private Double unitPrice;
}
