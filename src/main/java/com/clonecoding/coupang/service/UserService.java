package com.clonecoding.coupang.service;

import com.clonecoding.coupang.domain.User;
import com.clonecoding.coupang.dto.UserDto;
import com.clonecoding.coupang.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;

    @Transactional
    public Long putUser(UserDto userDto){
        User user = userDto.toEntity();
        userRepository.save(user);
        return user.getId();
    }

}
