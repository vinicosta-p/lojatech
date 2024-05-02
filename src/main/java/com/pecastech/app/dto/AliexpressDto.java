package com.pecastech.app.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
public record AliexpressDto(
    
    @NotBlank
    String id, 
    
    @NotBlank
    String ownerID, 
    
    @NotNull
    BigDecimal price,
    
    @NotBlank 
    String category
) {

}