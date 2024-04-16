package com.example.demo.TestCases;

import java.util.Collection;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.Controller.DepartmentController;
import com.example.demo.Controller.PersonController;
import com.example.demo.Repository.DepartmentRepository;
import com.example.demo.Repository.PersonRepository;
@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class DepartmentPhoneTest {
	@MockBean
	private DepartmentRepository departmentRepository;

	@Autowired
	DepartmentController departmentController;

	@Autowired
	private MockMvc mockMvc;
	@Test
	public void whenGet_DetailsOfDepartment() throws Exception {
		JSONObject json = new JSONObject();
		  
	        json.put("password", "st98@45hh");
	        json.put("email","strin72h@gmail099.com");
	      
	      
	        String user = json.toString();
	 
	        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user/login")
	        		.content(user)
	        		.contentType(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.status().isCreated())
					.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
					.andReturn();

	
	        String responseString = mvcResult.getResponse().getContentAsString();
	        
	        JSONObject reponsejson = new JSONObject(responseString);
	        System.out.println("reponsejson.get(\"token\"):"+reponsejson.get("token"));

	        mockMvc.perform(MockMvcRequestBuilders.get("/department/all")
				      .contentType(MediaType.APPLICATION_JSON)
				      .header("Authorization", "Bearer " + reponsejson.get("token")))  // Add this line
				    .andExpect(MockMvcResultMatchers.status().isOk())
				    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				    .andReturn();
			}
	
	
	@Test
	public void whenDepartmentList_NotNull()throws Exception
	{
		JSONObject json = new JSONObject();
		 json.put("password", "st98@45hh");
	        json.put("email","strin72h@gmail099.com");
        String user = json.toString();
 
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user/login")
        		.content(user)
        		.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andReturn();
        String responseString = mvcResult.getResponse().getContentAsString();
        JSONObject reponsejson = new JSONObject(responseString);
        System.out.println("reponsejson.get(\"token\"):"+reponsejson.get("token"));
        JSONObject department_list = new JSONObject();
        department_list.put("name", "sportssss");
        
        String departmentRequestBody = department_list.toString();
        mockMvc.perform(
                MockMvcRequestBuilders.post("/department/add")
                        .header("Authorization", "Bearer " + reponsejson.get("token"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(departmentRequestBody))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andReturn();
    }
	
	@Test
	public void to_Get_AllPhones()throws Exception
	{
		JSONObject json = new JSONObject();
		 json.put("password", "st98@45hh");
	        json.put("email","strin72h@gmail099.com");
      
      
        String user = json.toString();
 
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user/login")
        		.content(user)
        		.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andReturn();


        String responseString = mvcResult.getResponse().getContentAsString();
        
        JSONObject reponsejson = new JSONObject(responseString);
        System.out.println("reponsejson.get(\"token\"):"+reponsejson.get("token"));

        mockMvc.perform(MockMvcRequestBuilders.get("/phone/all")
			      .contentType(MediaType.APPLICATION_JSON)
			      .header("Authorization", "Bearer " + reponsejson.get("token")))  // Add this line
			    .andExpect(MockMvcResultMatchers.status().isOk())
			    .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
		}
	@Test
	public void whenDepartmentList_IsNull()throws Exception
	{
		JSONObject json = new JSONObject();
		 json.put("password", "st98@45hh");
	        json.put("email","strin72h@gmail099.com");
        String user = json.toString();
 
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/user/login")
        		.content(user)
        		.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
				.andReturn();
        String responseString = mvcResult.getResponse().getContentAsString();
        JSONObject reponsejson = new JSONObject(responseString);
        System.out.println("reponsejson.get(\"token\"):"+reponsejson.get("token"));
        JSONObject department_list = new JSONObject();
        department_list.put("id",JSONObject.NULL);
        department_list.put("name", JSONObject.NULL);
        

       
        
        String departmentRequestBody = department_list.toString();
        mockMvc.perform(
                MockMvcRequestBuilders.post("/department/add")
                        .header("Authorization", "Bearer " + reponsejson.get("token"))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(departmentRequestBody))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andReturn();
    }

	  
}
