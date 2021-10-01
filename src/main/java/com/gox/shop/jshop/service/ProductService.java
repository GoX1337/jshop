package com.gox.shop.jshop.service;

import com.gox.shop.jshop.dto.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<ProductDto> findAllProduct();

    Optional<ProductDto> findProduct(long id);
}
