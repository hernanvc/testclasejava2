package com.hernan.libreria.autor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    //User findByUsername(String username);
}
