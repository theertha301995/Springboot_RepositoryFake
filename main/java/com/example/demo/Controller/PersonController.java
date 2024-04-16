package com.example.demo.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Person;
import com.example.demo.Repository.PersonRepository;
import com.example.demo.service.PersonService;

import io.jsonwebtoken.security.InvalidKeyException;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "person", description = "The User API. Contains all the operations that can be performed on a user.")
@RequestMapping(path="/person")
public class PersonController {
	@Autowired
	private PersonService personService;
	@Autowired
	private PersonRepository personRepository;

	@PostMapping(path="/add")
	public ResponseEntity<Person> addPerson(@Valid @RequestBody Person person) {
		Person createdPerson;
 
		try {
			createdPerson = personService.createPerson(person);
 
		} catch (Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return new ResponseEntity<>(createdPerson, HttpStatus.CREATED);
	}


	@GetMapping("/all")
	public ResponseEntity<List<Person>> getAllPersons() {
		List<Person> allPersons = (List<Person>) personService.getPerson();
		return new ResponseEntity<>(allPersons, HttpStatus.OK);
	}

}