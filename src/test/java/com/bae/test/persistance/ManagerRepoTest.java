package com.bae.test.persistance;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistance.domain.Fighters;
import com.bae.persistance.domain.Manager;
import com.bae.persistance.repository.FighterRepository;
import com.bae.persistance.repository.ManagerRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ManagerRepoTest {

	@Autowired
	private ManagerRepository managerRepo;

	private final String TEST_USER_NAME = "john64";
	
	private final Manager TEST_MANAGER = new Manager(TEST_USER_NAME);
	
	private Manager testSavedManager;
	
	@Before
	public void init() {
		this.managerRepo.deleteAll();
		this.testSavedManager = this.managerRepo.save(this.TEST_MANAGER);
	}
	
	@Test
	public void testFindByUsername() {
		assertThat(this.managerRepo.findByUsername(this.TEST_USER_NAME)).isEqualTo(testSavedManager);
	}
}
