package com.hernan.libreria.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hernan.libreria.security.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
