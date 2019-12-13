package com.bae.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.persistance.domain.Manager;
import com.bae.persistance.repository.ManagerRepository;

@Service
public class ManagerService {

	private ManagerRepository managerRepo;
	
	public ManagerService(ManagerRepository managerRepo) {
		this.managerRepo = managerRepo;
	}
	
	public List<Manager> getAllManagers() {
		if (managerRepo.findAll().isEmpty()) {
			setUpManagers();
		}
		return managerRepo.findAll();
	}
	
	private void setUpManagers() {
	}
	
	public Manager addNewManager(Manager manager) {
		return managerRepo.save(manager);
	}
	
	public Manager updateManager(Manager manager) {
		return managerRepo.save(manager);
	}
	
	public String deleteManager(Long managerID) {
		managerRepo.deleteById(managerID);
		return "Manager successfully deleted";
	}
}
