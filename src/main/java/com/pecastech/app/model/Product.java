package com.pecastech.app.model;

import java.math.BigInteger;

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

    private String ownerId;
    
    private String name;

    private String category;

    private String shopId;

    private BigInteger price; 

    private BigInteger promotionPrice;

    private String description; 

    private String image; 

    private int quantity;
    
    private Boolean isAvailable;

}
