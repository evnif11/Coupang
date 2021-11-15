package com.clonecoding.coupang.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateDto {
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    private boolean advertisingAllow;
    private String role;
}
