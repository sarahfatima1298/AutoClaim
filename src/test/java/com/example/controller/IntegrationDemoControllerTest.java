package com.example.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.Application;
import com.example.entity.AutoClaim;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@AutoConfigureTestDatabase(connection =  EmbeddedDatabaseConnection.H2)
public class IntegrationDemoControllerTest {
	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	@Before
	public void setUp() {
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void testLogin() throws Exception {

		this.mvc.perform(get("/index")).andExpect(status().isOk())
		.andExpect(view().name("login"));
	}

	@Test
	public void testListDetails() throws Exception {	

		this.mvc.perform(get("/list")).andExpect(status().isOk())
		.andExpect(jsonPath("$.id").value(20174561L));
	}

	@Test
	public void testAddDetails() throws Exception {	
		AutoClaim mockedItem= new AutoClaim();
		mockedItem.setId(12345L);
		mockedItem.setClaimstatus("success");
		mockedItem.setContactnumber("123456");
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson=ow.writeValueAsString(mockedItem );

		this.mvc.perform(post("/add").contentType(APPLICATION_JSON_UTF8).content(requestJson)).andExpect(status().isOk());


	}

	@Test
	public void testDeleteDetails() throws Exception {			        
		this.mvc.perform(delete("/delete/12345L").accept(MediaType.APPLICATION_JSON)).andReturn().equals(true);

	}

}
