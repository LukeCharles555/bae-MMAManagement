package com.bae.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.persistance.domain.Manager;
import com.bae.service.ManagerService;

@RestController
@RequestMapping("/managerapp")
public class ManagerController {

	private ManagerService managerService;
	
	public ManagerController(ManagerService managerService) {
		this.managerService = managerService;
	}
	
	@GetMapping("/manager")
	public List<Manager> getAllManagers() {
		return managerService.getAllManagers();
	}
	
	@PostMapping("/manager")
	public Manager addNewManager(@RequestBody Manager manager) {
		return managerService.addNewManager(manager);
	}
	
	@PutMapping("/manager/{managerID}")
	public Manager updateManager(@PathParam("managerID") Long managerID, @RequestBody Manager manager) {
		return managerService.updateManager(manager, managerID);
	}
	
	@DeleteMapping("/manager/{managerID}")
	public String deleteManager(@PathVariable(value = "managerID") Long managerID) {
		return managerService.deleteManager(managerID);
	}
}
