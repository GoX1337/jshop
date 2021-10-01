package com.gox.shop.jshop.assembler;

import com.gox.shop.jshop.dto.ProductDto;
import com.gox.shop.jshop.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductAssembler {

    public ProductDto bo2dto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setQuantity(product.getQuantity());
        productDto.setCreationDate(product.getCreationDate());
        return productDto;
    }
}
