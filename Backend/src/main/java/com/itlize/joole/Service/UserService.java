package com.itlize.joole.Service;

import com.itlize.joole.Entity.User;

import java.util.Optional;

public interface UserService {
    User createUser(User user);

    User findByUsername(String username);
}
