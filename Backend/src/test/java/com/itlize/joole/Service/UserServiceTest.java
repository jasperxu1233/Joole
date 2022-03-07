package com.itlize.joole.Service;

import com.itlize.joole.Entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void createUser() {
        User user1 = new User();
        user1.setUsername("test1");
        user1.setPassword("123456");
        user1 .setRole("basic");

        userService.createUser(user1);

        User user2 = new User("test2", "222222", "admin");
        userService.createUser(user2);

        System.out.println(user1);
        System.out.println(user2);

        Assertions.assertNotNull(user1);
        Assertions.assertNotNull(user2);
    }

    @Test
    void findByUsername() {
        System.out.println("---------------------");
        User user3 = new User();
        user3.setUsername("test3");
        user3.setPassword("333");
        user3.setRole("Basic");

        userService.createUser(user3);
        User expected = userService.findByUsername("test3");

        System.out.println(user3);
        System.out.println(expected);

        assertEquals(user3.getUsername(), expected.getUsername());
        assertEquals(user3.getPassword(), expected.getPassword());
        assertEquals(user3.getRole(), expected.getRole());
    }
}