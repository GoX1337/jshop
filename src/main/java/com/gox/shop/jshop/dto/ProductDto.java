package com.gox.shop.jshop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ProductDto {

    private long id;
    private String name;
    private float price;
    private int stockQuantity;
    private LocalDateTime creationDate;

}
