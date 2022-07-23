package com.hernan.libreria.prestamos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/prestamo")
public class PrestamoRestController {

    @Autowired
    private PrestamoRepository prestamoRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Prestamo> findAll() {
        return prestamoRepository.findAll();
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/{prestamoId}")
    public Prestamo findOne(@PathVariable Long prestamoId) {
        return prestamoRepository.findOne(prestamoId);
    }
    
	@RequestMapping(method = RequestMethod.POST)
    public Prestamo add(@RequestBody Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }

	@RequestMapping(method = RequestMethod.PUT)
    public Prestamo update(@RequestBody Prestamo prestamo) {
        return prestamoRepository.save(prestamo);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{prestamoId}")
    public void delete(@PathVariable Long prestamoId) {
        prestamoRepository.delete(prestamoId);
    }
	
}

