package com.hernan.libreria.prestamos;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {
    //User findByUsername(String username);
}
