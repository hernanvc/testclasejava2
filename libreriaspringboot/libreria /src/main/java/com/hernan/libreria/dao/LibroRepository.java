package com.hernan.libreria.dao;

import com.hernan.libreria.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    //User findByUsername(String username);

    List<Libro> findAll();
}
