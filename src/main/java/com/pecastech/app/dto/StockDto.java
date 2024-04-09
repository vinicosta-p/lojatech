package com.pecastech.app.dto;

import java.math.BigDecimal;

public record StockDto(String name, 
String category, 
BigDecimal price, 
String description,
String image,
String freight,
String estimatedTime, 
int quantity) {
    
}
