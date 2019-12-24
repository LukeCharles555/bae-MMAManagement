package com.bae.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.exceptions.FighterNotFoundException;
import com.bae.persistance.domain.Fighters;
import com.bae.persistance.repository.FighterRepository;

@Service
public class FighterService {

	private FighterRepository fighterRepo;
	
	public FighterService(FighterRepository fighterRepo) {
		this.fighterRepo = fighterRepo;
	}
	
	public List<Fighters> getAllFighters() {
		return fighterRepo.findAll();
	}
	
	public Fighters addNewFighter(Fighters fighter) {
		return fighterRepo.save(fighter);
	}
	
	public Fighters updateFighter(Fighters fighter) {
		return fighterRepo.save(fighter);
	}
	
	public String deleteFighter(Long fighterID) {
		if (!this.fighterRepo.existsById(fighterID)) {
			throw new FighterNotFoundException();
		}
		fighterRepo.deleteById(fighterID);
		return "Fighter successfully deleted";
	}
	
	
}
