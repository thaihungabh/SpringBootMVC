package edu.iviettech.springbootmvc.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private String password;
}
