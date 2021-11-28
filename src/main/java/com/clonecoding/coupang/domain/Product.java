package com.clonecoding.coupang.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private int price;
    @Column(name = "discount_percent")
    private float discountPercent;
    @Column(name = "unit_price")
    private int unitPrice;
    private String category;
    @Column(name = "rocket_sign")
    private boolean rocketAvailable;
    private String thumbnail;
}
