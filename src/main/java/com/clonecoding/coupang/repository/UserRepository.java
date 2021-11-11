package com.clonecoding.coupang.repository;

import com.clonecoding.coupang.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
