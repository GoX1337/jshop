package com.gox.shop.jshop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
public class PageController {

    @GetMapping
    public String index(HttpSession session){
        log.info("GET / session_id: {}", session.getId());
        return "index";
    }
}
