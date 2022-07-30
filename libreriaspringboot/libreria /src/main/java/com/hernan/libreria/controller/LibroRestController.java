package com.hernan.libreria.controller;

import com.hernan.libreria.dao.LibroRepository;
import com.hernan.libreria.model.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/libro")
@CrossOrigin
public class LibroRestController {

    @Autowired
    private LibroRepository libroRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }
    

    
	@RequestMapping(method = RequestMethod.POST)
    public Libro add(@RequestBody Libro libro) {
        return libroRepository.save(libro);
    }

	@RequestMapping(method = RequestMethod.PUT)
    public Libro update(@RequestBody Libro libro) {
        return libroRepository.save(libro);
    }
	

	
}

