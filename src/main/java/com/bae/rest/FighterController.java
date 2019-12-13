package com.bae.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bae.persistance.domain.Fighters;
import com.bae.service.FighterService;

@RestController
@RequestMapping("/fighterapp")
public class FighterController {

	private FighterService fighterService;
	
	public FighterController(FighterService fighterService) {
		this.fighterService = fighterService;
	}
	
	@GetMapping("/fighters")
	public List<Fighters> getAllFighters() {
		return fighterService.getAllFighters();
	}
	
	@PostMapping("/fighters")
	public Fighters addNewFighter(@RequestBody Fighters fighter) {
		return fighterService.addNewFighter(fighter);
	}
	
	@PutMapping("/fighters")
	public Fighters updateFighter(@RequestBody Fighters fighter) {
		return fighterService.updateFighter(fighter);
	}
	
	@DeleteMapping("/fighters/{fighterID}")
	public String deleteFighter(@PathVariable(value = "fighterID") Long fighterID) {
		return fighterService.deleteFighter(fighterID);
	}
}
