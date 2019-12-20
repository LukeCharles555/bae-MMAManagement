package com.bae.test.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.persistance.domain.Manager;
import com.bae.persistance.repository.ManagerRepository;
import com.bae.service.ManagerService;

@RunWith(SpringRunner.class)
public class ManagerServiceUnitTest {

	@InjectMocks
	private ManagerService service;
	
	@Mock
	private ManagerRepository repo;
	
	private List<Manager> managerList;
	
	private Manager testManager;
	
	private Manager testManagerWithID;
	
	final long managerID = 1L;
	
	@Before
	public void init() {
		this.managerList = new ArrayList<>();
		this.managerList.add(testManager);
		this.testManager = new Manager("Luke");
		this.testManagerWithID = new Manager(testManager.getUsername());
		this.testManagerWithID.setManagerID(managerID);
	}
	
	@Test
	public void addManagerTest() {
		when(this.repo.save(testManager)).thenReturn(testManagerWithID);
		
		assertEquals(this.testManagerWithID, this.service.addNewManager(testManager));
		
		verify(this.repo, times(1)).save(this.testManager);
	}
	
	@Test
	public void deleteManagerTest() {
		when(this.repo.existsById(managerID)).thenReturn(true, false);
		
		this.service.deleteManager(managerID);
		
		verify(this.repo, times(1)).deleteById(managerID);
//		verify(this.repo, times(2)).existsById(managerID);
	}
	
	@Test
	public void getAllManagersTest() {
		when(repo.findAll()).thenReturn(this.managerList);
		
		assertFalse("Controller has found no managers", this.service.getAllManagers().isEmpty());
		
		 verify(repo, times(1)).findAll();
	}
	
	@Test
	public void updateManagerTest() {
		Manager newManager = new Manager("Joseph");
		Manager updatedManager = new Manager(newManager.getUsername());
		updatedManager.setManagerID(managerID);
		when(this.repo.findById(this.managerID)).thenReturn(Optional.of(this.testManagerWithID));
		when(this.repo.save(updatedManager)).thenReturn(newManager);
		
		assertEquals(updatedManager, this.service.updateManager(newManager));
		
//		verify(this.repo,times(1)).findById(1L);
		verify(this.repo, times(1)).save(updatedManager);
	}
}


