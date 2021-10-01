package com.gox.shop.jshop.repository;

import com.gox.shop.jshop.entity.Product;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @BeforeEach
    void setUp(){
        productRepository.deleteAll();
        Product p1 = new Product("Jambon", 5, 5000);
        Product p2 = new Product("Paté", 6, 3500);
        Product p3 = new Product("Saucisse", 2, 7500);
        productRepository.save(p1);
        productRepository.save(p2);
        productRepository.save(p3);
    }

    @Test
    void repoTest(){
        List<Product> productDtoList = productRepository.findAll();
        assertNotNull(productDtoList);
        assertEquals(3, productDtoList.size());
        assertEquals("Paté", productDtoList.get(1).getName());
    }

}