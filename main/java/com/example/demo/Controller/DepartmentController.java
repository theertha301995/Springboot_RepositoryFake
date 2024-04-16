package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Model.DepartmentList;
import com.example.demo.Repository.DepartmentRepository;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "department", description = "The User API. Contains all the operations that can be performed on a user.")
@RequestMapping(path="/department")
public class DepartmentController {
	@Autowired
    private DepartmentRepository departmentlistRepository;
    @GetMapping("/all") // Get all employees
    public Iterable<DepartmentList> getAllDepartments() {
		return departmentlistRepository.findAll();
    }
    @PostMapping(path = "/add")
   	ResponseEntity<DepartmentList> addNewDepartment(@Valid @RequestBody DepartmentList dept) {

    DepartmentList saveddepartment = departmentlistRepository.save(dept);
    return ResponseEntity.status(HttpStatus.CREATED).body(saveddepartment);
   	}
    

}
