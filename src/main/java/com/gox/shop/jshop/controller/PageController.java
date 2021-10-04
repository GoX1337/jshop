package com.gox.shop.jshop.controller;

import com.gox.shop.jshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
public class PageController {

    private final ProductService productService;

    @GetMapping
    public String index(HttpSession session, Model model){
        log.info("GET / session_id: {}", session.getId());
        model.addAttribute("products", productService.findAllProduct());
        return "index";
    }

    @GetMapping("/shop-cart")
    public String cart(HttpSession session){
        log.info("GET /shop-cart session_id: {}", session.getId());
        return "cart";
    }

    @GetMapping("/checkout")
    public String checkout(HttpSession session){
        log.info("GET /checkout session_id: {}", session.getId());
        return "checkout";
    }

    @GetMapping("/login")
    public String login(HttpSession session){
        log.info("GET /login session_id: {}", session.getId());
        return "login";
    }
}
