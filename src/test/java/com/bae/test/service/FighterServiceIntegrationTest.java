package com.bae.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistance.domain.Fighters;
import com.bae.persistance.repository.FighterRepository;
import com.bae.service.FighterService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FighterServiceIntegrationTest {

	@Autowired
	private FighterService service;

	@Autowired
	private FighterRepository repo;

	private Fighters testFighter;

	private Fighters testFighterWithID;
	
	@Before
	public void init() {
		this.repo.deleteAll();
		
		this.testFighter = new Fighters("Mr", "T", 70, 200);

		this.testFighterWithID = this.repo.save(this.testFighter);
	}
	
	@Test
	public void testAddNewFighter() {
		assertEquals(this.testFighterWithID, this.service.addNewFighter(testFighter));
	}

	@Test
	public void testDeleteFighter() {
		 assertThat(this.service.deleteFighter(this.testFighterWithID.getFighterID())).isEqualTo("Fighter successfully deleted");
	}

//	@Test
//	public void testFindDuckByID() {
//		assertThat(this.service.findDuckByID(this.testFighterWithID.getId())).isEqualTo(this.testDuckWithID);
//	}

	@Test
	public void testGetAllFighters() {
		assertThat(this.service.getAllFighters()).isEqualTo(Arrays.asList(new Fighters[] { this.testFighterWithID }));
	}

	@Test
	public void testUpdateFighter() {
		Fighters newFighter = new Fighters("Bucky", "Barnes", 60, 170);
		newFighter.setFighterID(this.testFighterWithID.getFighterID());
		Fighters updatedFighter = new Fighters(newFighter.getFirstName(), newFighter.getLastName(), newFighter.getHeight(), newFighter.getWeight());
		updatedFighter.setFighterID(this.testFighterWithID.getFighterID());

		assertThat(this.service.updateFighter(newFighter)).isEqualTo(updatedFighter);
	}
}
