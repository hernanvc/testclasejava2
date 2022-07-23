package com.hernan.libreria.lector;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/lector")
public class LectorRestController {

    @Autowired
    private LectorRepository lectorRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Lector> findAll() {
        return lectorRepository.findAll();
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/{lectorId}")
    public Lector findOne(@PathVariable Long lectorId) {
        return lectorRepository.findOne(lectorId);
    }
    
	@RequestMapping(method = RequestMethod.POST)
    public Lector add(@RequestBody Lector lector) {
        return lectorRepository.save(lector);
    }

	@RequestMapping(method = RequestMethod.PUT)
    public Lector update(@RequestBody Lector lector) {
        return lectorRepository.save(lector);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{lectorId}")
    public void delete(@PathVariable Long lectorId) {
        lectorRepository.delete(lectorId);
    }
	
}

