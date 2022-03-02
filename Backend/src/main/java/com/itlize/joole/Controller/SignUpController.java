package com.itlize.joole.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SignUpController {

    @PostMapping("/signUp/user")
    public void addUser() {

    }

    @PostMapping("/signUp/manufacturer")
    public void addManufacturer() {

    }

    @PostMapping("/signUp/admin")
    public void addAdministration() {

    }

}
