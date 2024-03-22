package com.pecastech.app.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pecastech.app.repository.ProductRepository;
import com.pecastech.app.services.AliexpressService;
import com.pecastech.app.dto.ItemRegistrationDto;
import com.pecastech.app.model.Product;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("products")
public class ProductsController {
    
    @Autowired
    ProductRepository productRepository;


    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok().body(productRepository.findAll());
    }

    @PostMapping()
    public ResponseEntity<ItemRegistrationDto> postProducts(@RequestBody ItemRegistrationDto item) {
        return ResponseEntity.ok().body(item);
    }

    @GetMapping("path")
    public String getMethodName() {
        RestTemplate rTemplate = new RestTemplate();

        JSONObject json = new JSONObject(rTemplate.getForEntity("https://api.hgbrasil.com/finance", String.class));
        return json.toString();
    }
    
}