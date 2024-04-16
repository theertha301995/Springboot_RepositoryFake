//package com.example.demo.Controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.demo.Model.Salary;
//import com.example.demo.service.SalarySevice;
//
//import jakarta.validation.Valid;
//
//@RestController
//@RequestMapping(path = "/emp")
//public class SalaryController {
//
//	@Autowired
//	private SalarySevice salaryService;
//
//	@PostMapping("/create")
//	public ResponseEntity<Salary> createSalary(@Valid @RequestBody Salary salary) {
//		Salary createdSalary;
//		try {
//			createdSalary = salaryService.createSalary(salary);
//		} catch (Exception e) {
//			e.printStackTrace();
//			// Handle exception if necessary
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//		}
//		return new ResponseEntity<>(createdSalary, HttpStatus.CREATED);
//	}
//
//	@GetMapping("/all")
//	public ResponseEntity<List<Salary>> getAllSalaries() {
//		List<Salary> allSalaries = (List<Salary>) salaryService.getSalary();
//		return new ResponseEntity<>(allSalaries, HttpStatus.OK);
//	}
//}