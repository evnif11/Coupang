package com.clonecoding.coupang.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String title;
    private int price;
    private float discountPercent;
    private int unitPrice;
    private String category;
    private boolean rocketAvailable;
    private String thumbnail;
}
