package com.gox.shop.jshop.component;

import com.gox.shop.jshop.entity.*;
import com.gox.shop.jshop.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.config.core.userdetails.UserDetailsResourceFactoryBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder bcryptEncoder;

    @Override
    public void run(String... args) throws Exception {

        Role r1 = new Role("ROLE_USER");
        Role r2 = new Role("ROLE_ADMIN");
        roleRepository.save(r1);
        roleRepository.save(r2);

        userRepository.save(new User("gox.roche@gmail.com", bcryptEncoder.encode("kek"), List.of(r1)));

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
