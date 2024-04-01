package com.pecastech.app.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.pecastech.app.repository.ProductRepository;
import com.pecastech.app.services.ProductService;
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
    ProductRepository repository;
    
    @Autowired
    ProductService service;


    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @PostMapping()
    public ResponseEntity<Product> postProducts(@RequestBody ItemRegistrationDto item) {
        
        return ResponseEntity.ok().body(service.insert(item));
    }

    @GetMapping("path")
    public double getMethodName() {
        RestTemplate rTemplate = new RestTemplate();

        String test = rTemplate.getForEntity("https://api.hgbrasil.com/finance", String.class)
                                .getBody();

        JSONObject json = new JSONObject(test);
        return json.getJSONObject("results").getJSONObject( "currencies").getJSONObject("USD").getDouble("buy");
    }
    
}