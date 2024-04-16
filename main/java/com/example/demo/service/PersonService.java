package com.example.demo.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Model.DepartmentList;
import com.example.demo.Model.Person;
import com.example.demo.Model.Phone;

import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Repository.PersonRepository;
import com.example.demo.Repository.PhoneRepository;

import jakarta.validation.Valid;
@Service
public class PersonService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private PhoneRepository phoneRepository;
	
	public Person createPerson(@RequestBody @Valid Person person) {
		  DepartmentList departmentFromClient = person.getDepartmentlist();
		  boolean departmentExist = false;
		  String personExist= person.getName();
		   if (personRepository.existsByName(person.getName())) {
	            throw new IllegalArgumentException("Name already in use");
	        }

		  if (departmentFromClient.getId() > 0) {
		    Optional<DepartmentList> departmentFromDb = departmentRepository.findById(departmentFromClient.getId());
		    if (departmentFromDb.isPresent()) {
		      person.setDepartmentlist(departmentFromDb.get());
		      departmentExist = true;
		    }
		  }

		  if (org.springframework.util.StringUtils.hasText(departmentFromClient.getName())) {
		    DepartmentList departmentFromDb = departmentRepository.findByName(departmentFromClient.getName());
		    if (departmentFromDb != null) {
		      person.setDepartmentlist(departmentFromDb);
		    }
		  }

		  Person savedPerson = personRepository.save(person);

		  // Iterate over a copy of the phone list to avoid ConcurrentModificationException
		  for (Phone phone : new ArrayList<>(person.getPhones())) {
		    phone.setPersons(person); // Set the relationship
		    phoneRepository.save(phone); // Save the phone
		  }
		  return savedPerson;
		}
	
	
	public Iterable<Person> getPerson() {
		return personRepository.findAll();
	}
}