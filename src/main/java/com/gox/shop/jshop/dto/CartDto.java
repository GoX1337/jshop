package com.gox.shop.jshop.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class CartDto {

    private Long id;
    private LocalDateTime creationDate;
    private LocalDateTime lastModificationDate;
    private List<CartItemDto> items = new ArrayList<>();
}
