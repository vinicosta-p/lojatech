package com.pecastech.app.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;

import com.pecastech.app.model.Product;

@SpringBootTest
public class ProductsServicetTest {

    @TestConfiguration
    static class ProductServiceTestConfig{
        @Bean
        public ProductService productService(){
            return new ProductService();
        }
    }
    
    @Autowired
    ProductService productService;

    @Test
    public void RetornoDeClasseProdutoCompleto(){
        Product product = new Product();
        Assertions.assertEquals(product.getName(), "Melissa");
        Assertions.assertEquals(22, 19);
    }
    @Test
    public void erroNoCampoVazio(){

    }
}
