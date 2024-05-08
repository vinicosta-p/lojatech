package com.pecastech.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pecastech.app.model.Product;

import jakarta.transaction.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{
    Product findByOwnerId(String ownerId);
    @Transactional
    void deleteByOwnerId(String ownerId);
}