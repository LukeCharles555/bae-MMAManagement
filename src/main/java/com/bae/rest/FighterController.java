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
import com.bae.service.FighterService;


@RestController
@RequestMapping("/fighterapp")
public class FighterController {

	
	@Autowired
	private FighterService fighterService;
	
	public FighterController(FighterService fighterService) {
		this.fighterService = fighterService;
	}
	
	@GetMapping("/fighters")
	public List<Fighters> getAllFighters() {
		return fighterService.getAllFighters();
	}
	
	@GetMapping("/fighters/{fighterID}")
	public Fighters getFighterByID(@PathVariable(value="fighterID") Long fighterID) {
		return fighterService.findFighterByID(fighterID);
	}
	
	@PostMapping("/fighters")
	public Fighters addNewFighter(@RequestBody Fighters fighter) {
		return fighterService.addNewFighter(fighter);
	}
	
	@PutMapping("/fighters/{fighterID}")
	public Fighters updateFighter(@PathParam("fighterID") Long fighterID, @RequestBody Fighters fighter) {
		return this.fighterService.updateFighter(fighter, fighterID);
	}
	
	@DeleteMapping("/fighters/{fighterID}")
	public void deleteFighter(@PathVariable Long fighterID) {
		this.fighterService.deleteFighter(fighterID);
	}
	
	@PatchMapping("/update/{fighterID}")
	public Fighters changeWeightOfFighter(@PathVariable Long fighterID, @RequestBody Fighters fighter) {
		return this.fighterService.changeWeightOfFighter(fighterID, fighter);
	}
}
