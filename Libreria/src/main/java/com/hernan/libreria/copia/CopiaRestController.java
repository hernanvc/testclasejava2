package com.hernan.libreria.copia;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/copia")
public class CopiaRestController {

    @Autowired
    private CopiaRepository copiaRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Copia> findAll() {
        return copiaRepository.findAll();
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/{copiaId}")
    public Copia findOne(@PathVariable Long copiaId) {
        return copiaRepository.findOne(copiaId);
    }
    
	@RequestMapping(method = RequestMethod.POST)
    public Copia add(@RequestBody Copia copia) {
        return copiaRepository.save(copia);
    }

	@RequestMapping(method = RequestMethod.PUT)
    public Copia update(@RequestBody Copia copia) {
        return copiaRepository.save(copia);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{copiaId}")
    public void delete(@PathVariable Long copiaId) {
        copiaRepository.delete(copiaId);
    }
	
}

