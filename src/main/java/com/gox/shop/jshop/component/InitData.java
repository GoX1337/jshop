package com.gox.shop.jshop.component;

import com.gox.shop.jshop.entity.Product;
import com.gox.shop.jshop.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitData implements CommandLineRunner {

    private final ProductRepository productRepository;

    public InitData(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("INIT DATA");
        Product p1 = new Product("Jambon", 5, 5000);
        Product p2 = new Product("Paté", 6, 3500);
        Product p3 = new Product("Saucisse", 2, 7500);

        productRepository.save(p1);
        productRepository.save(p2);
        productRepository.save(p3);
    }
}
