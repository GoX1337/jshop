package com.gox.shop.jshop.service.impl;

import com.gox.shop.jshop.assembler.ProductAssembler;
import com.gox.shop.jshop.dto.ProductDto;
import com.gox.shop.jshop.repository.ProductRepository;
import com.gox.shop.jshop.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductAssembler productAssembler;

    public ProductServiceImpl(ProductRepository productRepository, ProductAssembler productAssembler) {
        this.productRepository = productRepository;
        this.productAssembler = productAssembler;
    }

    @Override
    public List<ProductDto> findAllProduct() {
        return productRepository
                .findAll()
                .stream()
                .map(productAssembler::bo2dto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDto> findProduct(long id) {
        return productRepository.findById(id).map(productAssembler::bo2dto);
    }
}
