package com.gox.shop.jshop.service.impl;

import com.gox.shop.jshop.assembler.ProductAssembler;
import com.gox.shop.jshop.dto.ProductDto;
import com.gox.shop.jshop.entity.Product;
import com.gox.shop.jshop.repository.ProductRepository;
import com.gox.shop.jshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp(){
        productService = new ProductServiceImpl(productRepository, new ProductAssembler());
    }

    @Test
    void findAllProduct() {


        given(productRepository.findById(1L)).willReturn(Optional.of(new Product(1L, "Jambon", 5, 5000, LocalDateTime.now())));
        Optional<ProductDto> popt = productService.findProduct(1L);
        verify(productRepository).findById(1L);
        assertTrue(popt.isPresent());
        assertEquals("Jambon", popt.get().getName());
    }

    @Test
    void findProduct() {
        given(productRepository.findById(1L)).willReturn(Optional.of(new Product(1L, "Jambon", 5, 5000, LocalDateTime.now())));
        Optional<ProductDto> popt = productService.findProduct(1L);
        verify(productRepository).findById(1L);
        assertTrue(popt.isPresent());
        assertEquals("Jambon", popt.get().getName());
    }
}