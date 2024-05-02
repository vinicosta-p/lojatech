package com.pecastech.app.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * OwnerIdDto
 */
public record OwnerIdDto(
    @Size(min = 5, max = 10, message = "About Me must be between 5 and 10 characters")
    @NotBlank(message = "OwnerId cannot be null") 
    @Pattern(regexp = "[0-9]*")
    String id
) {

}