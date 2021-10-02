package com.gox.shop.jshop.assembler;

import com.gox.shop.jshop.dto.CartDto;
import com.gox.shop.jshop.dto.CartItemDto;
import com.gox.shop.jshop.entity.Cart;
import com.gox.shop.jshop.entity.CartItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CartAssembler {

    private final ProductAssembler productAssembler;

    public CartItemDto bo2dtoItem(CartItem cartItem){
        CartItemDto cartItemDto = new CartItemDto();
        cartItemDto.setId(cartItem.getId());
        cartItemDto.setQuantity(cartItem.getQuantity());
        cartItemDto.setProduct(productAssembler.bo2dto(cartItem.getProduct()));
        return cartItemDto;
    }

    public CartDto bo2dto(Cart cart){
        CartDto cartDto = new CartDto();
        cartDto.setCreationDate(cart.getCreationDate());
        cartDto.setLastModificationDate(cart.getLastModificationDate());
        cartDto.setItems(cart.getItems().stream().map(this::bo2dtoItem).collect(Collectors.toList()));
        return cartDto;
    }
}
