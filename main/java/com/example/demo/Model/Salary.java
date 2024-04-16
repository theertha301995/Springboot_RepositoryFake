//package com.example.demo.Model;
//
//
//
//import com.example.demo.UnitTestController.CustomValidation;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import jakarta.validation.constraints.Min;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.NotNull;
//
//@Entity
//@Table(name="salary")
//public class Salary {
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private int salary_id;
//	@NotBlank(message = "Salary is mandatory")
//	private String emp_salary;
//	@NotNull(message = "Employee ID is mandatory")
//	@Min(value = 2, message = "Employee ID must be greater than 2")
//	private int employee_id;
//	//@NotNull
//	 @CustomValidation
//	private String age;
////	public int getSalary_id() {
////		return salary_id;
////	}
//
//	public void setSalary_id(int salary_id) {
//		this.salary_id = salary_id;
//	}
//
//	public String getEmp_salary() {
//		return emp_salary;
//	}
//
//	public void setEmp_salary(String emp_salary) {
//		this.emp_salary = emp_salary;
//	}
//
//	public int getEmployee_id() {
//		return employee_id;
//	}
//
//	public void setEmployee_id(int employee_id) {
//		this.employee_id = employee_id;
//	}
//    
//	
//	public String getAge() {
//		return age;
//		
//	}
//	  public void setAge(String age) {
//	        this.age = age;
//	    }
//
//	
//
//}
