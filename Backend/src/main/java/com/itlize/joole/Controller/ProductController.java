package com.itlize.joole.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping("/getAllProduct")
    public void getAllProducts() {

    }

    @GetMapping("/getProduct")
    public void getProduct() {

    }

    @PostMapping("/addProduct")
    public void addProduct() {

    }

    @PostMapping("/deleteProduct")
    public void deleteProduct() {

    }

    @PostMapping("/deleteAllProduct")
    public void deleteAllProducts() {

    }

    @PostMapping("/updateProduct")
    public void updateProduct() {

    }

}
