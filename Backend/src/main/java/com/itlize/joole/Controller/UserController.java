package com.itlize.joole.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping("/signUp")
    public void signUp() {

    }

    @GetMapping("/login")
    public void login() {

    }

    @PostMapping("/delete")
    public void deleteUser() {

    }

//    @PostMapping("/signUp/manufacturer")
//    public void addManufacturer() {
//
//    }
//
//    @PostMapping("/signUp/admin")
//    public void addAdministration() {
//
//    }
    //waiting to implement // token or session?
    //waiting to implement // token or session?

}
