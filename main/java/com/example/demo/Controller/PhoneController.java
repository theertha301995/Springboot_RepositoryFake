package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Model.Phone;
import com.example.demo.Repository.PhoneRepository;


@RestController
@RequestMapping(path="/phone")
public class PhoneController {
	@Autowired
	private PhoneRepository phoneRepository;
	
	@GetMapping(path = "/all")
	public @ResponseBody Iterable<Phone> getAllPhones() {
		// This returns a JSON or XML with the users
		return phoneRepository.findAll();
	}

}
