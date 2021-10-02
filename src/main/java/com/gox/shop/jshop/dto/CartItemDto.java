package com.gox.shop.jshop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CartItemDto {

    private Long id;
    private ProductDto product;
    private int quantity;
}
