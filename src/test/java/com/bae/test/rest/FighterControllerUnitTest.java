package com.bae.test.rest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistance.domain.Fighters;
import com.bae.rest.FighterController;
import com.bae.service.FighterService;

@RunWith(SpringRunner.class)
public class FighterControllerUnitTest {

	@InjectMocks
	private FighterController controller;
	
	@Mock
	private FighterService service;
	
	private List<Fighters> fighterList;
	
	private Fighters testFighter;
	
	private Fighters testFighterWithID;
	
	public final long fighterID = 1L;
	
	@Before
	public void init() {
		this.fighterList = new ArrayList<>();
		this.fighterList.add(testFighter);
		this.testFighter = new Fighters("John", "Greg", 60, 180);
		this.testFighterWithID = new Fighters(testFighter.getFirstName(), testFighter.getLastName(), testFighter.getHeight(), testFighter.getWeight());
		this.testFighterWithID.setFighterID(fighterID);
	}
	
	@Test
	public void addFighterTest() {
		when(this.service.addNewFighter(testFighter)).thenReturn(testFighterWithID);
		
		assertEquals(this.testFighterWithID, this.controller.addNewFighter(testFighter));
		
		verify(this.service, times(1)).addNewFighter(this.testFighter);
		
	}
	
	@Test
	public void deleteFighterTest() {
		this.controller.deleteFighter(fighterID);
		
		verify(this.service, times(1)).deleteFighter(fighterID);
	}
	
	@Test
	public void findFighterByIDTest() {
		when(this.service.findFighterByID(this.fighterID)).thenReturn(this.testFighterWithID);
		
		assertEquals(this.testFighterWithID, this.controller.getFighterByID(this.fighterID));
		
		verify(this.service, times(1)).findFighterByID(this.fighterID);
	}
	
	@Test
	public void getAllFightersTest() {
		when(service.getAllFighters()).thenReturn(this.fighterList);
		
		assertFalse("Controller has found no fighters", this.controller.getAllFighters().isEmpty());
		
		verify(service, times(1)).getAllFighters();
	}
	
	@Test
	public void updateFightersTest() {
		Fighters newFighter = new Fighters("Mr", "T", 70, 200);
		Fighters updatedFighter = new Fighters(newFighter.getFirstName(), newFighter.getLastName(), newFighter.getHeight(), newFighter.getWeight());
		updatedFighter.setFighterID(this.fighterID);
		
		when(this.service.updateFighter(newFighter, this.fighterID)).thenReturn(updatedFighter);
		
		assertEquals(updatedFighter, this.controller.updateFighter(this.fighterID, newFighter));
		
		verify(this.service, times(1)).updateFighter(newFighter, this.fighterID);
	}
}
