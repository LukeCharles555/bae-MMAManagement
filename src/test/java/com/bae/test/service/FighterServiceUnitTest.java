package com.bae.test.service;

import static org.junit.Assert.assertEquals;
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
import com.bae.persistance.repository.FighterRepository;
import com.bae.service.FighterService;

@RunWith(SpringRunner.class)
public class FighterServiceUnitTest {

	@InjectMocks
	private FighterService service;
	
	@Mock
	private FighterRepository repo;
	
	private List<Fighters> fighterList;
	
	private Fighters testFighter;
	
	private Fighters testFighterWithID;
	
	final long fighterID = 1L;
	
	@Before
	public void init() {
		this.fighterList = new ArrayList<>();
		this.fighterList.add(testFighter);
		this.testFighter = new Fighters("John", "Greg", 80, 200);
		this.testFighterWithID = new Fighters(testFighter.getFirstName(), testFighter.getLastName(), testFighter.getHeight(), testFighter.getWeight());
		this.testFighterWithID.setFighterID(fighterID);
	}
	
	@Test
	public void addFighterTest() {
		when(this.repo.save(testFighter)).thenReturn(testFighterWithID);
		
		assertEquals(this.testFighterWithID, this.service.addNewFighter(testFighter));
		
		verify(this.repo, times(1)).save(this.testFighter);
	}
}
