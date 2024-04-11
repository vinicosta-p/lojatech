package com.pecastech.app.dto;

import java.math.BigDecimal;
public record AliexpressDto(String id, String ownerID, BigDecimal price, String category) {

}