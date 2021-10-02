package com.gox.shop.jshop.service;

import com.gox.shop.jshop.dto.CartDto;

import java.util.Optional;

public interface CartService {

    Optional<CartDto> findCart(long id);

}
