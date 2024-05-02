package com.pecastech.app.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record StockDto(
    @NotBlank
    String name, 
    @NotBlank
    String ownerID,
    @NotBlank
    String category, 
    @NotNull
    BigDecimal price, 
    @NotBlank
    String description,
    @NotBlank
    String image,
    @NotBlank
    String freight,
    @NotBlank
    String estimatedTime, 
    @NotNull
    int quantity

) {
    
}
