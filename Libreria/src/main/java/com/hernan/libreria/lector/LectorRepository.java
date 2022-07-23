package com.hernan.libreria.lector;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LectorRepository extends JpaRepository<Lector, Long> {
    //User findByUsername(String username);
}
