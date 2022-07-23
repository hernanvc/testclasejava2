package com.hernan.libreria.copia;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CopiaRepository extends JpaRepository<Copia, Long> {
    //User findByUsername(String username);
}
