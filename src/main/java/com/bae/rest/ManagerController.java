package com.bae.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.persistance.domain.Fighters;
import com.bae.persistance.domain.Manager;
import com.bae.service.ManagerService;

@RestController
@RequestMapping("/managerapp")
public class ManagerController {

	private ManagerService managerService;
	
	@Autowired
	public ManagerController(ManagerService managerService) {
		super();
		this.managerService = managerService;
	}
	
	@GetMapping("/manager")
	public List<Manager> getAllManagers() {
		return managerService.getAllManagers();
	}
	
	@GetMapping("/manager/{managerID}")
	public Manager getManagerByID(@PathVariable(value="managerID") Long managerID) {
		return managerService.findManagerByID(managerID);
	}
	
	@PostMapping("/manager")
	public Manager addNewManager(@RequestBody Manager fighter) {
		return this.managerService.addNewManager(fighter);
	}
	
//	@PutMapping("/manager/{managerID}")
//	public Manager updateManager(@PathParam("managerID") Long managerID, @RequestBody Manager manager) {
//		return this.managerService.updateManager(manager, managerID);
//	}
	
	@DeleteMapping("/manager/{managerID}")
	public String deleteManager(@PathVariable(value = "managerID") Long managerID) {
		return managerService.deleteManager(managerID);
	}
	
	@PatchMapping("/update/{managerID}")
	public Manager addFighterToManager(@PathVariable Long managerID, @RequestBody Fighters fighter) {
		return this.managerService.addFighterToManager(managerID, fighter);
	}
}
