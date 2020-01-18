package com.bae.test.exceptions;

import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.exceptions.FighterNotFoundException;
import com.bae.persistance.domain.Fighters;
import com.bae.persistance.repository.FighterRepository;
import com.bae.service.FighterService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FighterNotFoundExceptionTest {

	@Autowired
	private FighterService service;
	
	@Autowired
	private FighterRepository repo;
	
	private Fighters testFighter;
	
	private Fighters testFighterWithID;
	
	final long fighterID = 1L;
	
	@Before
	public void init() {
		this.repo.deleteAll();
		
		this.testFighter = new Fighters("Luke", "P", 60, 180);
		
		this.testFighterWithID = this.repo.save(this.testFighter);
	}
	
	@Test(expected = FighterNotFoundException.class)
	public void testFighterNotFoundException() {
		
		this.service.findFighterByID(3L);
	
	}
	
	
}
