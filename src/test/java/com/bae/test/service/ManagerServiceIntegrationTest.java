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
import com.bae.persistance.domain.Manager;
import com.bae.persistance.repository.FighterRepository;
import com.bae.persistance.repository.ManagerRepository;
import com.bae.service.FighterService;
import com.bae.service.ManagerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerServiceIntegrationTest {

	@Autowired
	private ManagerService service;

	@Autowired
	private ManagerRepository repo;

	private Manager testManager;

	private Manager testManagerWithID;
	
	@Before
	public void init() {
		this.repo.deleteAll();
		
		this.testManager = new Manager("1234");

		this.testManagerWithID = this.repo.save(this.testManager);
	}
	
	@Test
	public void testAddNewManager() {
		assertEquals(this.testManagerWithID, this.service.addNewManager(testManager));
	}

	@Test
	public void testDeleteFighter() {
		 assertThat(this.service.deleteManager(this.testManagerWithID.getManagerID())).isEqualTo("Manager successfully deleted");
	}

	@Test
	public void testFindManagerByID() {
		assertThat(this.service.findManagerByID(this.testManagerWithID.getManagerID())).isEqualTo(this.testManagerWithID);
	}

	@Test
	public void testGetAllManager() {
		assertThat(this.service.getAllManagers()).isEqualTo(Arrays.asList(new Manager[] { this.testManagerWithID }));
	}

	@Test
	public void testUpdateDuck() {
		Manager newManager = new Manager("4321");
		newManager.setManagerID(this.testManagerWithID.getManagerID());
		Manager updatedManager = new Manager(newManager.getUsername());
		updatedManager.setManagerID(this.testManagerWithID.getManagerID());

		assertThat(this.service.updateManager(newManager, newManager.getManagerID())).isEqualTo(updatedManager);
	}
}
