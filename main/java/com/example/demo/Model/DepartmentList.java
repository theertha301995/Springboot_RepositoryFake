package com.example.demo.Model;
import java.util.List;
 
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;
 
@Entity
public class DepartmentList {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	@NotNull
    @Column (unique=true)
    private String name;
    
  
    @OneToMany(mappedBy = "departmentlist",cascade=CascadeType.ALL)
    private List<Person> persons;
 
	
 
//	public List<EmployeeNew> getEmployees() {
//		return employees;
//	}
 
//	public void setEmployees(List<Person> persons) {
//		this.persons = persons;
//	}
 
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
	
 
 
}
 
