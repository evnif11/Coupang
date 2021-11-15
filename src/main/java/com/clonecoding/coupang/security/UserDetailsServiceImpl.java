package com.clonecoding.coupang.security;

import com.clonecoding.coupang.domain.User;
import com.clonecoding.coupang.dto.UserDto;
import com.clonecoding.coupang.repository.UserRepository;
import com.clonecoding.coupang.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<UserDto> user = userService.findByEmail(email);
        return new UserDetailsImpl(
                user.orElseThrow(
                        () -> new UsernameNotFoundException("not found user")
                )
        );
    }
}
