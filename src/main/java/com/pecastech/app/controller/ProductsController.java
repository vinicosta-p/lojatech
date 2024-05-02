package com.pecastech.app.controller;

import org.springframework.web.bind.annotation.RestController;

import com.pecastech.app.repository.ProductRepository;
import com.pecastech.app.services.ProductService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import com.pecastech.app.dto.AliexpressDto;
import com.pecastech.app.dto.OwnerIdDto;
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
    public ResponseEntity<Product> postItemAliexpress(@RequestBody @Valid AliexpressDto item) {
        
        return ResponseEntity.ok().body(service.insert(item));
    }

    @PostMapping("stock")
    public ResponseEntity<Product> postItem(@RequestBody @Valid StockDto item) {

        return ResponseEntity.ok().body(service.insert(item));
    }
    // validar na requisição
    @PutMapping("{ownerId}")
    public ResponseEntity<?> putItem(@PathVariable @Size(min = 5, max = 10, message = "About Me must be between 5 and 10 characters")
    @NotBlank(message = "OwnerId cannot be null") @Pattern(regexp = "[0-9]*") OwnerIdDto ownerId, @RequestBody StockDto stockDto) {

        service.put(ownerId.id(),stockDto);
        return ResponseEntity.ok().build();
    }
    // validar na requisição
    @DeleteMapping("{ownerId}")
    public ResponseEntity<?> deleteItem(@PathVariable @Size(min = 5, max = 10, message = "About Me must be between 5 and 10 characters")
    @NotBlank(message = "OwnerId cannot be null") @Pattern(regexp = "[0-9]*") String ownerId){
        System.out.println(ownerId);
       // service.delete(ownerId.id());
        return ResponseEntity.ok().build();
    }

}