package com.itlize.joole.Repository;

import com.itlize.joole.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

     void signIn(User user);

    void signUp(User user);

}