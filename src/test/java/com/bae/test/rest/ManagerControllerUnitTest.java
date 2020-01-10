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

import com.bae.persistance.domain.Manager;
import com.bae.rest.FighterController;
import com.bae.rest.ManagerController;
import com.bae.service.FighterService;
import com.bae.service.ManagerService;

@RunWith(SpringRunner.class)
public class ManagerControllerUnitTest {

	@InjectMocks
	private ManagerController controller;
	
	@Mock
	private ManagerService service;
	
	private List<Manager> managerList;
	
	private Manager testManager;
	
	private Manager testManagerWithID;
	
	final long managerID = 1L;
	
	@Before
	public void init() {
		this.managerList = new ArrayList<>();
		this.managerList.add(testManager);
		this.testManager = new Manager("Username");
		this.testManagerWithID = new Manager(testManager.getUsername());
		this.testManagerWithID.setManagerID(managerID);
	}
	
	@Test
	public void addManagerTest() {
		when(this.service.addNewManager(testManager)).thenReturn(testManagerWithID);
		
		assertEquals(this.testManagerWithID, this.controller.addNewManager(testManager));
		
		verify(this.service, times(1)).addNewManager(this.testManager);
		
	}
	
	@Test
	public void deleteManagerTest() {
		this.controller.deleteManager(managerID);
		
		verify(this.service, times(1)).deleteManager(managerID);
	}
	
	@Test
	public void getAllManagersTest() {
		when(service.getAllManagers()).thenReturn(this.managerList);
		
		assertFalse("Controller has found no managers", this.controller.getAllManagers().isEmpty());
		
		verify(service, times(1)).getAllManagers();
	}
	
	@Test
	public void updateManagersTest() {
		Manager newManager = new Manager("LukeyBoi");
		Manager updatedManager = new Manager(newManager.getUsername());
		updatedManager.setManagerID(this.managerID);
		
		when(this.service.updateManager(newManager)).thenReturn(updatedManager);
		
		assertEquals(updatedManager, this.controller.updateManager(newManager));
		
		verify(this.service, times(1)).updateManager(newManager);
	}
}
