package edu.iviettech.springbootmvc.service;

import edu.iviettech.springbootmvc.entity.UserEntity;
import edu.iviettech.springbootmvc.model.User;

public interface UserService {
    Long createUser(User user);
    User findByUserId(Long userId);
}
