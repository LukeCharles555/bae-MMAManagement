package com.bae.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.bae.persistance.domain.Manager;
import com.bae.service.ManagerService;

public class ManagerController {

	private ManagerService managerService;
	
	public ManagerController(ManagerService managerService) {
		this.managerService = managerService;
	}
	
	@GetMapping("/manager")
	public List<Manager> getAllManagers() {
		return managerService.getAllManagers;
	}
	
	@PostMapping("/manager")
	public Manager addNewManager(@RequestBody Manager manager) {
		return managerService.addNewManager(manager);
	}
	
	@PutMapping("/manager")
	public Manager updateManager(@RequestBody Manager manager) {
		return managerService.updateManager(manager);
	}
	
	@DeleteMapping("/manager/{managerID}")
	public String deleteManager(@PathVariable(value = "managerID") Long managerID) {
		return managerService.deleteManager(managerID);
	}
}
