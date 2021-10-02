package com.gox.shop.jshop.assembler;

import com.gox.shop.jshop.dto.ProductDto;
import com.gox.shop.jshop.entity.Product;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ProductAssemblerTest {

    private ProductAssembler productAssembler;

    @BeforeEach
    void setUp(){
        productAssembler = new ProductAssembler();
    }

    @Test
    void bo2dto() {
        LocalDateTime now = LocalDateTime.now();
        Product product = new Product(1L, "Jambon", 5, 5000, now);
        ProductDto productDto = productAssembler.bo2dto(product);
        assertEquals(1L, productDto.getId());
        assertEquals(5000, productDto.getStockQuantity());
        assertEquals("Jambon", productDto.getName());
        assertEquals(5, productDto.getPrice());
        assertEquals(now, productDto.getCreationDate());
    }
}