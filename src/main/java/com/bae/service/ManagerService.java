package com.bae.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.exceptions.ManagerNotFoundException;
import com.bae.persistance.domain.Fighters;
import com.bae.persistance.domain.Manager;
import com.bae.persistance.repository.ManagerRepository;

@Service
public class ManagerService {

	private ManagerRepository managerRepo;
	
	private FighterService fighterService;
	
	public ManagerService(ManagerRepository managerRepo, FighterService fighterService) {
		this.managerRepo = managerRepo;
		this.fighterService = fighterService;
	}
	
	public List<Manager> getAllManagers() {
		return managerRepo.findAll();
	}
	
	public Manager addNewManager(Manager manager) {
		return managerRepo.save(manager);
	}
	
	public Manager findManagerByID(Long managerID) {
		return this.managerRepo.findById(managerID).orElseThrow(() -> new ManagerNotFoundException());
	}
	
	public Manager updateManager(Manager manager, Long managerID) {
		Manager toUpdate = findManagerByID(managerID);
		toUpdate.setUsername(manager.getUsername());
		return this.managerRepo.save(toUpdate);
	}
	
	public Manager addFighterToManager(Long managerID, Fighters fighter) {
		Manager toUpdate = findManagerByID(managerID);
		Fighters newFighter = this.fighterService.addNewFighter(fighter);
		toUpdate.getFighters().add(fighter);
		return this.managerRepo.saveAndFlush(toUpdate);
	}
	
	public String deleteManager(Long managerID) {
		if (!this.managerRepo.existsById(managerID)) {
			throw new ManagerNotFoundException();
		}
		managerRepo.deleteById(managerID);
		return "Manager successfully deleted";
	}

	public Manager getManagerByID(Long managerID) {
		return managerRepo.getOne(managerID);
	}
}
