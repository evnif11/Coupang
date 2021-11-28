package com.clonecoding.coupang.service;

import com.clonecoding.coupang.domain.Product;
import com.clonecoding.coupang.dto.ProductDto;
import com.clonecoding.coupang.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public List<ProductDto> listAll() {
        List<Product> productList = productRepository.findAll();
        List<ProductDto> productDtoList = productList.stream().map(this::toDto).collect(Collectors.toList());
        return productDtoList;
    }

    @Transactional
    public Optional<ProductDto> findByTitle(String title) {
        Optional<Product> product = productRepository.findByTitle(title);
        return product.map(this::toDto);
    }

    private ProductDto toDto(Product product){
        return ProductDto.builder()
                .title(product.getTitle())
                .price(product.getPrice())
                .unitPrice(product.getUnitPrice())
                .discountPercent(product.getDiscountPercent())
                .category(product.getCategory())
                .thumbnail(product.getThumbnail())
                .rocketAvailable(product.isRocketAvailable())
                .build();
    }
}
