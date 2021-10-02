package com.gox.shop.jshop.component;

import com.gox.shop.jshop.entity.Cart;
import com.gox.shop.jshop.entity.CartItem;
import com.gox.shop.jshop.entity.Product;
import com.gox.shop.jshop.repository.CartItemRepository;
import com.gox.shop.jshop.repository.CartRepository;
import com.gox.shop.jshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitData implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    @Override
    public void run(String... args) throws Exception {
        Product p1 = new Product("Jambon", 5, 5000);
        Product p2 = new Product("Paté", 6, 3500);
        Product p3 = new Product("Saucisse", 2, 7500);
        productRepository.save(p1);
        productRepository.save(p2);
        productRepository.save(p3);

        Cart cart = new Cart();
        cart.getItems().add(new CartItem(null, p1, 2));
        cart.getItems().add(new CartItem(null, p3, 5));
        cartRepository.save(cart);
    }
}
