package com.itlize.joole.Service.Servicelmp;

import com.itlize.joole.Entity.Product;
import com.itlize.joole.Repository.ProductRepository;
import com.itlize.joole.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServicelmp implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findByProductId(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public List<Product> findAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByManufacturer(String manufacturer) {
        return productRepository.findByManufacturer(manufacturer).orElse(null);
    }

    @Override
    public List<Product> findByPowerMinGreaterThanEqual(double powerMin) {
        return productRepository.findByPowerMinGreaterThanEqual(powerMin).orElse(null);
    }

    @Override
    public List<Product> findByFanSpeedMaxIsLessThanEqual(double fanSpeedMax) {
        return productRepository.findByFanSpeedMaxIsLessThanEqual(fanSpeedMax).orElse(null);
    }
}
