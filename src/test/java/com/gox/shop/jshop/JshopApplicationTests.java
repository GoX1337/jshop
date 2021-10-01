package com.gox.shop.jshop;

import com.gox.shop.jshop.controller.ProductController;
import com.gox.shop.jshop.entity.Product;
import com.gox.shop.jshop.repository.ProductRepository;
import com.gox.shop.jshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class JshopApplicationTests {

	@Autowired
	private ProductController productController;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ProductService productService;

	@Autowired
	private MockMvc mockMvc;

	private Product p1;
	private Product p2;
	private Product p3;

	@Test
	void contextLoads() {
		assertNotNull(productController);
		assertNotNull(productService);
		assertNotNull(productRepository);
		JshopApplication.main(new String[0]);
	}

	@BeforeEach
	void deleteProducts(){
		productRepository.deleteAll();
		p1 = productRepository.save(new Product("Jambon", 5, 5000));
		p2 = productRepository.save(new Product("Paté", 6, 3500));
		p3 = productRepository.save(new Product("Saucisse", 2, 7500));
	}

	@Test
	@WithMockUser
	void getProductById1() throws Exception {
		RequestBuilder req = MockMvcRequestBuilders.get("/product/" + p1.getId());
		mockMvc.perform(req)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("Jambon"))
				.andExpect(jsonPath("$.price").value(5));
	}

	@Test
	@WithMockUser
	void getProductById2() throws Exception {
		RequestBuilder req = MockMvcRequestBuilders.get("/product/" + p2.getId());
		mockMvc.perform(req)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("Paté"))
				.andExpect(jsonPath("$.price").value( 6));
	}

	@Test
	@WithMockUser
	void getProductById3() throws Exception {
		RequestBuilder req = MockMvcRequestBuilders.get("/product/" + p3.getId());
		mockMvc.perform(req)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value("Saucisse"))
				.andExpect(jsonPath("$.quantity").value(7500));
	}

	@Test
	@WithMockUser
	void notFound() throws Exception {
		RequestBuilder req = MockMvcRequestBuilders.get("/product/7");
		mockMvc.perform(req)
				.andExpect(status().isNotFound());
	}

	@Test
	@WithMockUser
	void getProducts() throws Exception {
		RequestBuilder req = MockMvcRequestBuilders.get("/product");
		mockMvc.perform(req)
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name").value("Jambon"))
				.andExpect(jsonPath("$[1].price").value(6))
				.andExpect(jsonPath("$[2].quantity").value(7500));
	}

}
