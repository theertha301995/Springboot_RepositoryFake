//package com.example.demo.Testing;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import com.example.demo.Controller.SalaryController;
//import com.example.demo.Repository.SalaryRepository;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest
//@AutoConfigureMockMvc
//public class TestingSalary {
//	@MockBean
//	private SalaryRepository salaryRepository;
//
//	@Autowired
//	SalaryController salaryController;
//
//	@Autowired
//	private MockMvc mockMvc;
//
//	@Test
//	public void whenPostRequestToUsersAndValidUser_thenCorrectResponse() throws Exception {
//
//		String user = "{\"emp_salary\": \"150000\", \"employee_id\": 1999, \"age\": 80.8}";
//
//		mockMvc.perform(MockMvcRequestBuilders.post("/emp/add").content(user).contentType(MediaType.APPLICATION_JSON))
//				.andExpect(MockMvcResultMatchers.status().isCreated())
//				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
//	}
//
//	@Test
//	public void whenEmployeeSalaryIsNull() throws Exception {
//		String user = "{\"emp_salary\": null, \"employee_id\": 1999, \"age\": 80.8}";
//		mockMvc.perform(MockMvcRequestBuilders.post("/emp/add").content(user).contentType(MediaType.APPLICATION_JSON))
//				.andExpect(MockMvcResultMatchers.status().isBadRequest());
//
//	}
//
//	@Test
//	public void whenEmployeeIdIsNull() throws Exception {
//		String user = "{\"emp_salary\": \"150000\", \"employee_id\": null, \"age\": 80.8}";
//		mockMvc.perform(MockMvcRequestBuilders.post("/emp/add").content(user).contentType(MediaType.APPLICATION_JSON))
//				.andExpect(MockMvcResultMatchers.status().isBadRequest());
//
//	}
//
//	@Test
//	public void whenAgeIsNull() throws Exception {
//		String user = "{\"emp_salary\": \"150000\", \"employee_id\": 1999, \"age\": null}";
//		mockMvc.perform(MockMvcRequestBuilders.post("/emp/add").content(user).contentType(MediaType.APPLICATION_JSON))
//				.andExpect(MockMvcResultMatchers.status().isBadRequest());
//	}
//
//	@Test
//	public void whenEmployeeSalaryIsDefault() throws Exception {
//		String user = "{\"emp_salary\":\"\",\"employee_id\":1999,\"age\":75.3}";
//		mockMvc.perform(MockMvcRequestBuilders.post("/emp/add").content(user).contentType(MediaType.APPLICATION_JSON))
//				.andExpect(MockMvcResultMatchers.status().isBadRequest());
//
//	}
//	@Test
//	public void whenEmployeeIdIsDefault()throws Exception{
//		String user= "{\"emp_salary\":\"16000\",\"employee_id\":0,\"age\":89.6}";
//		mockMvc.perform(MockMvcRequestBuilders.post("/emp/add").content(user).contentType(MediaType.APPLICATION_JSON))
//		.andExpect(MockMvcResultMatchers.status().isBadRequest());
//	}
//	@Test
//	public void whenAgeIsDefault()throws Exception{
//		String user= "{\"emp_salary\":\"16000\",\"employee_id\":1899,\"age\":0.0}";
//		mockMvc.perform(MockMvcRequestBuilders.post("/emp/add").content(user).contentType(MediaType.APPLICATION_JSON))
//		.andExpect(MockMvcResultMatchers.status().isBadRequest());
//	}
//	public void whenAgeFractionStartsWithZero()throws Exception{
//		String user= "{\"emp_salary\":\"16000\",\"employee_id\":1899,\"age\":1.08}";
//		mockMvc.perform(MockMvcRequestBuilders.post("/emp/add").content(user).contentType(MediaType.APPLICATION_JSON))
//		.andExpect(MockMvcResultMatchers.status().isBadRequest());
//	}
//	public void whenAgeIntegerPartStartsWithOne()throws Exception{
//		String user= "{\"emp_salary\":\"16000\",\"employee_id\":1899,\"age\":1}";
//		mockMvc.perform(MockMvcRequestBuilders.post("/emp/add").content(user).contentType(MediaType.APPLICATION_JSON))
//		.andExpect(MockMvcResultMatchers.status().isCreated());
//	}
//	
//	public void whenAgeFractionPartAndIntegerPartIsZero()throws Exception{
//		String user= "{\"emp_salary\":\"16000\",\"employee_id\":1899,\"age\":0.0}";
//		mockMvc.perform(MockMvcRequestBuilders.post("/emp/add").content(user).contentType(MediaType.APPLICATION_JSON))
//		.andExpect(MockMvcResultMatchers.status().isCreated());
//	}
//	
//	
//	
//}
//
//
//
//
