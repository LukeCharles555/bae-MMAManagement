package com.bae.test.exceptions;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.bae.exceptions.ManagerNotFoundException;
import com.bae.persistance.domain.Manager;
import com.bae.persistance.repository.ManagerRepository;
import com.bae.service.ManagerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManagerNotFoundExceptionTest {

	@Autowired
	private ManagerService service;
	
	@Autowired
	private ManagerRepository repo;
	
	private Manager testManager;
	
	private Manager testManagerWithID;
	
	final long managerID = 1L;
	
	@Before
	public void init() {
		this.repo.deleteAll();
		
		this.testManager = new Manager("Luke");
		
		this.testManagerWithID = this.repo.save(this.testManager);
	}
	
	@Test(expected = ManagerNotFoundException.class)
	public void testManagerNotFoundException() {
		
		this.service.findManagerByID(3L);
		
	}
}
