package com.pecastech.app.controller;

import org.springframework.web.bind.annotation.RestController;

import com.pecastech.app.repository.ProductRepository;
import com.pecastech.app.services.ProductService;
import com.pecastech.app.dto.AliexpressDto;
import com.pecastech.app.dto.StockDto;
import com.pecastech.app.model.Product;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("api/products")
public class ProductsController {
    
    @Autowired
    ProductRepository repository;
    
    @Autowired
    ProductService service;


    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok().body(repository.findAll());
    }

    @PostMapping("aliexpress")
    public ResponseEntity<Product> postItemAliexpress(@RequestBody AliexpressDto item) {
        
        return ResponseEntity.ok().body(service.insert(item));
    }

    @PostMapping("stock")
    public ResponseEntity<Product> postItem(@RequestBody StockDto item) {

        return ResponseEntity.ok().body(service.insert(item));
    }

    @PutMapping("{ownerId}")
    public ResponseEntity<?> putItem(@PathVariable String ownerId, @RequestBody StockDto stockDto) {
        service.put(ownerId,stockDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{ownerId}")
    public ResponseEntity<?> deleteItem(@PathVariable String ownerId){
        service.delete(ownerId);
        return ResponseEntity.ok().build();
    }

}