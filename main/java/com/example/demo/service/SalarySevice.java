//package com.example.demo.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import com.example.demo.Model.Salary;
//import com.example.demo.Repository.SalaryRepository;
//
//import jakarta.validation.Valid;
//
//@Service
//public class SalarySevice {
//	@Autowired
//	private SalaryRepository salaryRepository;
//
//	public Salary createSalary(@RequestBody @Valid Salary salary) throws Exception {
//		throwException();
//		salaryRepository.save(salary);
//		return salary;
//
//	}
//
//	public Iterable<Salary> getSalary() {
//		return salaryRepository.findAll();
//	}
//
//	private void throwException() throws Exception {
//		throw new Exception("ex");
//
//	}
//
//}
