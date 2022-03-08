package com.itlize.joole.Controller;

import com.itlize.joole.Entity.User;
import com.itlize.joole.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userService.findByUsername(user.getUsername()) != null) {
            return new ResponseEntity<>((HttpStatus.CONFLICT));
        }
        return new ResponseEntity<>(userService.createUser(user), HttpStatus.CREATED);
    }

    //NOT DONE
    @PostMapping("/login")
    public ResponseEntity<?> login(Principal principal) {
        if (principal == null) {
            //use ok because it'll be used for logout path?
            return ResponseEntity.ok(principal);
        }
        //authentication stuff
        User user = userService.findByUsername(principal.getName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
