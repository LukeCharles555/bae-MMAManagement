package com.bae.test.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.bae.persistance.domain.Fighters;
import com.bae.persistance.domain.Manager;
import com.bae.persistance.repository.ManagerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ManagerControllerIntegrationTest {

	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ManagerRepository repo;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	private long managerID;
	
	private Manager testManager;
	
	private Manager testManagerWithID;
	
	private List<Fighters> fighters;
	
	@Before
	public void init() {
		this.repo.deleteAll();
		
		this.testManager = new Manager("1234");
		this.testManagerWithID = this.repo.save(this.testManager);
		this.managerID = this.testManagerWithID.getManagerID();
		this.fighters = this.testManagerWithID.getFighters();
	}
	
	@Test
	public void testAddNewManager() throws Exception {
		String result = this.mock
						.perform(request(HttpMethod.POST, "/managerapp/manager").contentType(MediaType.APPLICATION_JSON)
								.content(this.mapper.writeValueAsString(testManager)).accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		assertEquals(this.mapper.writeValueAsString(testManagerWithID), result);
	}
	
	@Test
	public void testDeleteManager() throws Exception {
		this.mock.perform(request(HttpMethod.DELETE, "/managerapp/manager/" + this.managerID)).andExpect(status().isOk());
	}
	
	

}
