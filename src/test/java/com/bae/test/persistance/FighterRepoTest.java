package com.bae.test.persistance;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistance.domain.Fighters;
import com.bae.persistance.repository.FighterRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class FighterRepoTest {
	
	@Autowired
	private FighterRepository fighterRepo;

	private final String TEST_FIRST_NAME = "John";
	
	private final Fighters TEST_FIGHTER = new Fighters(TEST_FIRST_NAME, "Greg", 60, 180);
	
	private Fighters testSavedFighter;
	
	@Before
	public void init() {
		this.fighterRepo.deleteAll();
		this.testSavedFighter = this.fighterRepo.save(this.TEST_FIGHTER);
	}
	
	@Test
	public void testFindByName() {
		assertThat(this.fighterRepo.findByFirstName(this.TEST_FIRST_NAME)).isEqualTo(testSavedFighter);
	}
	
	
}
