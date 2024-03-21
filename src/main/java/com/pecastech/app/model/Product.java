package com.pecastech.app.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="product")
@Table(name="product")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    public Product(String name, BigDecimal price, String description, String image, BigDecimal freight,
            String estimatedTime, Boolean isAvailable) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.image = image;
        this.freight = freight;
        this.estimatedTime = estimatedTime;
        this.isAvailable = isAvailable;
    }

    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private BigDecimal price; 

    private String description; 

    private String image; 

    private BigDecimal freight; 

    private String estimatedTime; 
    
    private Boolean isAvailable;

}
