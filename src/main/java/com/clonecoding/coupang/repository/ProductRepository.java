package com.clonecoding.coupang.repository;

import com.clonecoding.coupang.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
