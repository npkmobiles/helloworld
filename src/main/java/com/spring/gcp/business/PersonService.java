/**
 * 
 */
package com.spring.gcp.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.gcp.models.Person;

/**
 * @author npk61
 *
 */
@Service
public class PersonService {
	
	List<Person> persons = new ArrayList<>();

	public Person createPerson(String name) {
		Person person = new Person(UUID.randomUUID().toString(), name);
		persons.add(person);
		return person;
	}
	
	public List<Person> allPersons() {
		return persons;
	}
	
	public List<Person> findPersonByName(String name) {
		return persons.stream().filter(p -> p.getName().equals(name)).collect(Collectors.toList());
	}
	
	public Optional<Person> findPersonById(String id) {
		Optional<Person> person = persons.stream().
			    filter(p -> p.getId().equals("testemail")).
			    findFirst();
		return person;
		/*
		 *List<Person> olderThan30 = 
    //Create a Stream from the personList
    personList.stream().
    //filter the element to select only those with age >= 30
    filter(p -> p.age >= 30).
    //put those filtered elements into a new List.
    collect(Collectors.toCollection(() -> new ArrayList<Person>()));
System.out.println(olderThan30);
		 */
	}
}
