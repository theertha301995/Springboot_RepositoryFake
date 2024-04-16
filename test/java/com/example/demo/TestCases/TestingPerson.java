package com.example.demo.TestCases;

import org.json.JSONArray;
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

import com.example.demo.Controller.PersonController;
import com.example.demo.Repository.PersonRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class TestingPerson {
	@MockBean
	private PersonRepository personRepository;

	@Autowired
	PersonController personController;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void whenGet_DetailsOfPerson() throws Exception {
		JSONObject json = new JSONObject();
		 json.put("password", "st98@45hh");
	        json.put("email","strin72h@gmail099.com");

		String user = json.toString();

		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.post("/user/login").content(user)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)).andReturn();

		String responseString = mvcResult.getResponse().getContentAsString();

		JSONObject reponsejson = new JSONObject(responseString);
		System.out.println("reponsejson.get(\"token\"):" + reponsejson.get("token"));

		mockMvc.perform(MockMvcRequestBuilders.get("/person/all").contentType(MediaType.APPLICATION_JSON)
				.header("Authorization", "Bearer " + reponsejson.get("token")))
				.andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void When_Post_Person_Details() throws Exception {
		JSONObject json = new JSONObject();
		 json.put("password", "st98@45hh");
	        json.put("email","strin72h@gmail099.com");
		String user = json.toString();

		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.post("/user/login").content(user)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)).andReturn();
		String responseString = mvcResult.getResponse().getContentAsString();
		JSONObject reponsejson = new JSONObject(responseString);
		System.out.println("reponsejson.get(\"token\"):" + reponsejson.get("token"));
		JSONObject department_list = new JSONObject();
		department_list.put("id", 352);

		JSONArray phones = new JSONArray();
		JSONObject phone1 = new JSONObject();
		phone1.put("id", "9");
		phone1.put("number", "9876543210");
		phones.put(phone1);

		JSONObject phone2 = new JSONObject();
		phone2.put("id", "2");
		phone2.put("number", "9876543210");
		phones.put(phone2);

		JSONObject person = new JSONObject();

		person.put("name", "anamika");
		person.put("age", 30);
		person.put("departmentlist", department_list);
		person.put("phones", phones);

		String personRequestBody = person.toString();
		mockMvc.perform(
				MockMvcRequestBuilders.post("/person/add").header("Authorization", "Bearer " + reponsejson.get("token"))
						.contentType(MediaType.APPLICATION_JSON).content(personRequestBody))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	public void person_IsNull() throws Exception {
		JSONObject json = new JSONObject();
		 json.put("password", "st98@45hh");
	        json.put("email","strin72h@gmail099.com");
		String user = json.toString();

		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.post("/user/login").content(user)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)).andReturn();
		String responseString = mvcResult.getResponse().getContentAsString();
		JSONObject reponsejson = new JSONObject(responseString);
		System.out.println("reponsejson.get(\"token\"):" + reponsejson.get("token"));
		JSONObject department_list = new JSONObject();
		department_list.put("id", 352);

		JSONArray phones = new JSONArray();
		JSONObject phone1 = new JSONObject();
		phone1.put("number", "9876543210");
		phones.put(phone1);

		JSONObject phone2 = new JSONObject();
		phone2.put("number", "9876543210");
		phones.put(phone2);

		JSONObject person = new JSONObject();
		person.put("id", JSONObject.NULL);
		person.put("name", JSONObject.NULL);
		person.put("age", JSONObject.NULL);
		person.put("departmentlist", JSONObject.NULL);
		person.put("phones", JSONObject.NULL);

		String personRequestBody = person.toString();
		mockMvc.perform(
				MockMvcRequestBuilders.post("/person/add").header("Authorization", "Bearer " + reponsejson.get("token"))
						.contentType(MediaType.APPLICATION_JSON).content(personRequestBody))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	public void checkDepartmentExist() throws Exception {
		JSONObject json = new JSONObject();
		 json.put("password", "st98@45hh");
	        json.put("email","strin72h@gmail099.com");
		String user = json.toString();

		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.post("/user/login").content(user)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)).andReturn();
		String responseString = mvcResult.getResponse().getContentAsString();
		JSONObject reponsejson = new JSONObject(responseString);
		System.out.println("reponsejson.get(\"token\"):" + reponsejson.get("token"));
		JSONObject department_list = new JSONObject();
		department_list.put("id", 92);

		JSONArray phones = new JSONArray();
		JSONObject phone1 = new JSONObject();
		phone1.put("id", 987);
		phone1.put("number", "9876543210");
		phones.put(phone1);

		JSONObject phone2 = new JSONObject();
		phone2.put("id", 907);
		phone2.put("number", "9876543210");
		phones.put(phone2);

		JSONObject person = new JSONObject();
		person.put("departmentlist", department_list);
		person.put("age", 30);
		person.put("name", "saru");
		person.put("phones", phones);

		String personRequestBody = person.toString();
		mockMvc.perform(
				MockMvcRequestBuilders.post("/person/add").header("Authorization", "Bearer " + reponsejson.get("token"))
						.contentType(MediaType.APPLICATION_JSON).content(personRequestBody))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}

	@Test
	public void checkUserUnauthorized() throws Exception {
		JSONObject json = new JSONObject();
		 json.put("password", "st98@45hh");
	        json.put("email","strin72h@gmail099.com");
		String user = json.toString();

		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.post("/user/login").content(user)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)).andReturn();
		String responseString = mvcResult.getResponse().getContentAsString();
		JSONObject reponsejson = new JSONObject(responseString);
		System.out.println("reponsejson.get(\"token\"):" + reponsejson.get("token"));
		JSONObject department_list = new JSONObject();
		department_list.put("id", 92);

		JSONArray phones = new JSONArray();
		JSONObject phone1 = new JSONObject();
		phone1.put("id", 500);
		phone1.put("number", "9876543210");
		phones.put(phone1);

		JSONObject phone2 = new JSONObject();
		phone2.put("id", 501);
		phone2.put("number", "9876543210");
		phones.put(phone2);

		JSONObject person = new JSONObject();
		person.put("departmentlist", department_list);
		person.put("age", 30);
		person.put("name", "saru");
		person.put("phones", phones);

		String personRequestBody = person.toString();
		mockMvc.perform(MockMvcRequestBuilders.post("/person/add").contentType(MediaType.APPLICATION_JSON)
				.content(personRequestBody)).andExpect(MockMvcResultMatchers.status().isUnauthorized());
	}

	@Test
	public void checkDepartmentNameExist() throws Exception {
		JSONObject json = new JSONObject();
		 json.put("password", "st98@45hh");
	        json.put("email","strin72h@gmail099.com");
		String user = json.toString();

		MvcResult mvcResult = mockMvc
				.perform(MockMvcRequestBuilders.post("/user/login").content(user)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isCreated())
				.andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON)).andReturn();
		String responseString = mvcResult.getResponse().getContentAsString();
		JSONObject reponsejson = new JSONObject(responseString);
		System.out.println("reponsejson.get(\"token\"):" + reponsejson.get("token"));
		JSONObject department_list = new JSONObject();
		department_list.put("id", 352);
        department_list.put("name", "Sales");
		JSONArray phones = new JSONArray();
		JSONObject phone1 = new JSONObject();
		phone1.put("id", "9");
		phone1.put("number", "9876543210");
		phones.put(phone1);

		JSONObject phone2 = new JSONObject();
		phone2.put("id", "2");
		phone2.put("number", "9876543210");
		phones.put(phone2);

		JSONObject person = new JSONObject();

		person.put("name", "anamika");
		person.put("age", 30);
		person.put("departmentlist", department_list);
		person.put("phones", phones);

		String personRequestBody = person.toString();
		mockMvc.perform(
				MockMvcRequestBuilders.post("/person/add").header("Authorization", "Bearer " + reponsejson.get("token"))
						.contentType(MediaType.APPLICATION_JSON).content(personRequestBody))
				.andExpect(MockMvcResultMatchers.status().isCreated());
	}
	
	@Test
	   public void verify_TokenAuthentication()throws Exception
	   {
		   JSONObject json = new JSONObject();

			json.put("user_id", 345);
			json.put("user_name", "anuh");
			json.put("password", "Anua#hhg");
			json.put("email", "anusree@gmail.com");
			json.put("name", "Sanu");

			String user = json.toString();
	        String invalid_token="invalid_token";
			

			JSONObject department_list = new JSONObject();
			department_list.put("id", 352);

			JSONArray phones = new JSONArray();
			JSONObject phone1 = new JSONObject();
			phone1.put("id", "9");
			phone1.put("number", "9876543210");
			phones.put(phone1);

			JSONObject phone2 = new JSONObject();
			phone2.put("id", "2");
			phone2.put("number", "9876543210");
			phones.put(phone2);

			JSONObject person = new JSONObject();

			person.put("name", "anamika");
			person.put("age", 30);
			person.put("departmentlist", department_list);
			person.put("phones", phones);

			String personRequestBody = person.toString();
			mockMvc.perform(
					MockMvcRequestBuilders.post("/person/add")
							.contentType(MediaType.APPLICATION_JSON).content(personRequestBody))
					.andExpect(MockMvcResultMatchers.status().isUnauthorized());
		   
	   }

}

	

