package com.gox.shop.jshop.service.impl;

import com.gox.shop.jshop.assembler.CartAssembler;
import com.gox.shop.jshop.dto.CartDto;
import com.gox.shop.jshop.repository.CartRepository;
import com.gox.shop.jshop.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CartAssembler cartAssembler;

    @Override
    public Optional<CartDto> findCart(long id) {
        return cartRepository.findById(id).map(cartAssembler::bo2dto);
    }
}
