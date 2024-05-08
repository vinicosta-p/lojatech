package com.pecastech.app.dto;

import java.math.BigInteger;

import org.springframework.web.bind.annotation.PathVariable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record StockDto(
    @NotBlank
    String name, 

    @NotBlank
    @PathVariable 
    @Size(min = 5, max = 10)
    @Pattern(regexp = "[0-9]*")
    String ownerID,

    @NotBlank
    String category, 

    @NotNull
    BigInteger price, 

    @NotBlank
    String description,

    @NotBlank
    String image,

    @NotNull
    int quantity,

    BigInteger promotionPrice

) {
    
}
