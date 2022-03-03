package com.itlize.joole.Service;

import com.itlize.joole.Entity.User;

import java.util.Optional;

public interface UserService {
    User createUser(User user);

    User findByUserId(Long userId);

    User findByUsername(String username);

    void signIn(User user);

    void signUp(User user);

}
