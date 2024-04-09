package com.pecastech.app.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="product")
@Table(name="product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {

    @Id 
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String category;

    private String shopId;

    private BigDecimal price; 

    private BigDecimal promotionPrice;

    private String description; 

    private String image; 

    private int quantity;
    
    private Boolean isAvailable;

    private String freight; 

    private String estimatedTime; 
    
  

}
