package com.digitrack.demo.controller;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.digitrack.demo.model.Person;
import com.digitrack.demo.repository.PersonRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("api/person")
public class PersonController {
	
	@Autowired
	private PersonRepository personRepository;
	
	@GetMapping
	public Page<Person> Get(@RequestParam(required = false) String birthDate,    
                            @RequestParam(required = false) String sex,
                            Pageable pageable)
	{		    
		return personRepository.findAll(sex,birthDate,pageable);		
	}

	@PostMapping	
	public Person Post(@Valid @RequestBody Person person) {
		return personRepository.save(person);		
	}
	
	@PutMapping("/{id}")
	public void Put(@Valid @RequestBody Person person, @PathVariable long id) {

		Optional<Person> entity = personRepository.findById(id);

		if (!entity.isPresent()) {
			 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found");
		}
		person.setId(id);		
		personRepository.save(person);
	}
	
	 @DeleteMapping("/{id}")
	    public void Delete(@PathVariable Long id) {
	         personRepository.deleteById(id);	 
	 }
	
	@GetMapping("/existCpf")
	public boolean ExistCpf(@RequestParam String cpf,@RequestParam(required = false) Long id) {
		var exist = false;
		exist = personRepository.findCpf(cpf,id) > 0;
		return exist;
	}
	
}
