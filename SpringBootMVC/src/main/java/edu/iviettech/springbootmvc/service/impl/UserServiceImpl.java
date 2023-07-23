package edu.iviettech.springbootmvc.service.impl;

import edu.iviettech.springbootmvc.converter.UserConverter;
import edu.iviettech.springbootmvc.model.User;
import edu.iviettech.springbootmvc.repository.UserRepository;
import edu.iviettech.springbootmvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public Long createUser(User user) {
        return userRepository.save(UserConverter.toEntity(user)).getId();
    }

    @Override
    public User findByUserId(Long userId) {
        return UserConverter.toModel(userRepository.findByUserId(userId));
    }
}
