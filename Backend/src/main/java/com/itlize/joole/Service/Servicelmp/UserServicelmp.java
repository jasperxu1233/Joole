package com.itlize.joole.Service.Servicelmp;

import com.itlize.joole.Entity.User;
import com.itlize.joole.Repository.UserRepository;
import com.itlize.joole.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServicelmp implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findById(username).orElse(null);
    }


}

