/**
 * 
 */
package com.spring.gcp.controllers;

import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.gcp.business.PersonService;
import com.spring.gcp.models.Person;

import lombok.extern.slf4j.Slf4j;

/**
 * @author npk61
 *
 */
@RestController
@RequestMapping("/persons")
@Slf4j
public class PersonController {
	
	private PersonService personService;

	@PostMapping("/{name}")
	public Person create(@PathVariable String name) {
		log.info("PersonController ---> create() ---> name: ", name);
		Person person = personService.createPerson(name);
		log.info("PersonController ---> create() ---> name: ", person);
				return person;
	}
	
	@GetMapping("/name/{name}")
	public List<Person> findbyName(@PathVariable String name) {
		log.info("PersonController ---> findbyName() ---> name: ", name);
		List<Person> persons = personService.findPersonByName(name);
		log.info("PersonController ---> findbyName() ---> persons: ", persons);
				return persons;
	}
	
	@GetMapping("/id/{id}")
	public Optional<Person> findbyId(@PathVariable String id) {
		log.info("PersonController ---> findbyId() ---> name: ", id);
		Optional<Person> person = personService.findPersonById(id);
		log.info("PersonController ---> findbyId() ---> name: ", person);
				return person;
	}
	
	@GetMapping("/all")
	public List<Person> listAll() {
		log.info("PersonController ---> listAll() ");
		List<Person> persons = personService.allPersons();
		log.info("PersonController ---> listAll() ---> persons: ", persons);
				return persons;
	}
}
