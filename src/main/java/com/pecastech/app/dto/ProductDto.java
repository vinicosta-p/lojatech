package com.pecastech.app.dto;

import java.math.BigDecimal;

public record ProductDto(
String name, 
BigDecimal price, 
BigDecimal profitMargin, 
String description,
String image,
BigDecimal freight,
String estimatedTime, 
Boolean isAvailable) {
    
}
