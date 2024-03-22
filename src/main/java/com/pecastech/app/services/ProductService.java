package com.pecastech.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pecastech.app.repository.ProductRepository;

@Service
public class ProductService {
    
    @Autowired
    AliexpressService aliexpressService;

    @Autowired
    ProductRepository repository;

    
    
}
