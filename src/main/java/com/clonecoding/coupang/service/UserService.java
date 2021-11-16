package com.clonecoding.coupang.service;

import com.clonecoding.coupang.domain.User;
import com.clonecoding.coupang.dto.UserCreateDto;
import com.clonecoding.coupang.dto.UserDto;
import com.clonecoding.coupang.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public UserDto create(UserCreateDto dto){
        User user = toEntity(dto);
        userRepository.save(user);
        return toDto(user);
    }

    public Optional<UserDto> findByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        return user.map(this::toDto);
    }

    private User toEntity(UserCreateDto dto) {
        String hashedPassword = passwordEncoder.encode(dto.getPassword());

        return User.builder()
                .email(dto.getEmail())
                .password(hashedPassword)
                .name(dto.getName())
                .phoneNumber(dto.getPhoneNumber())
                .build();
    }

    private UserDto toDto(User user){
        return UserDto.builder()
                .email(user.getEmail())
                .name(user.getName())
                .hashedPassword(user.getPassword())
                .phoneNumber(user.getPhoneNumber())
                .build();
    }
}
