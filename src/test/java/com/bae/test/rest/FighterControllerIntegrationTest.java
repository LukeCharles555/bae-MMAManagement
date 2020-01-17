package com.bae.test.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;
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
import com.bae.persistance.repository.FighterRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FighterControllerIntegrationTest {

	@Autowired
	private MockMvc mock;
	
	@Autowired
	private FighterRepository repo;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	private long fighterID;
	
	private Fighters testFighter;
	
	private Fighters testFighterWithID;
	
	@Before
	public void init() {
		this.repo.deleteAll();
		
		this.testFighter = new Fighters("Barry", "Plum", 70, 180);
		this.testFighterWithID = this.repo.save(this.testFighter);
		this.fighterID = this.testFighterWithID.getFighterID();
	}
	
	@Test
	public void testAddNewFighter() throws Exception {
		String result = this.mock
						.perform(request(HttpMethod.POST, "/fighterapp/fighters").contentType(MediaType.APPLICATION_JSON)
								.content(this.mapper.writeValueAsString(testFighter)).accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		assertEquals(this.mapper.writeValueAsString(testFighterWithID), result);
	}
	
	@Test
	public void testDeleteFighter() throws Exception {
		this.mock.perform(request(HttpMethod.DELETE, "/fighterapp/fighters/" + this.fighterID)).andExpect(status().isOk());
	}
	
	@Test
	public void testGetAllFighters() throws Exception {
		List<Fighters> fighterList = new ArrayList<>();
		fighterList.add(this.testFighterWithID);
		
		String content = this.mock.perform(request(HttpMethod.GET, "/fighterapp/fighters").accept(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
		
		assertEquals(this.mapper.writeValueAsString(fighterList), content);
	}
	
//	@Test
//	public void testUpdateFighter() throws Exception {
//		Fighters newFighter = new Fighters("Mr", "T", 75, 200);
//		Fighters updatedFighter = new Fighters(newFighter.getFirstName(), newFighter.getLastName(), newFighter.getHeight(), newFighter.getWeight());
//		updatedFighter.setFighterID(this.fighterID);
//		
//		String result = this.mock
//				.perform(request(HttpMethod.PUT, "/fighterapp/fighters/?fighterID=" + this.fighterID).accept(MediaType.APPLICATION_JSON)
//						.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(newFighter)))
//				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
//		
//		assertEquals(this.mapper.writeValueAsString(updatedFighter), result);
//	}
	
//	@Test
//	public void testChangeWeightOfFighter() throws Exception {
//		Fighters newFighter = new Fighters("Mr", "T", 75, 200);
//		Fighters updatedFighter = new Fighters(newFighter.getFirstName(), newFighter.getLastName(), newFighter.getHeight(), newFighter.getWeight());
//		updatedFighter.setFighterID(this.fighterID);
//		
//		String result = this.mock
//				.perform(request(HttpMethod.PATCH, "/fighterapp/update/?fighterID=" + this.fighterID).accept(MediaType.APPLICATION_JSON)
//						.contentType(MediaType.APPLICATION_JSON).content(this.mapper.writeValueAsString(newFighter)))
//				.andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
//		
//		assertEquals(this.mapper.writeValueAsString(updatedFighter), result);
//	}
	
}
