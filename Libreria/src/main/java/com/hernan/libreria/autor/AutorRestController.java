package com.hernan.libreria.autor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/autor")
public class AutorRestController {

    @Autowired
    private AutorRepository autorRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Autor> findAll() {
        return autorRepository.findAll();
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/{autorId}")
    public Autor findOne(@PathVariable Long autorId) {
        return autorRepository.findOne(autorId);
    }
    
	@RequestMapping(method = RequestMethod.POST)
    public Autor add(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }

	@RequestMapping(method = RequestMethod.PUT)
    public Autor update(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{autorId}")
    public void delete(@PathVariable Long autorId) {
        autorRepository.delete(autorId);
    }
	
}

