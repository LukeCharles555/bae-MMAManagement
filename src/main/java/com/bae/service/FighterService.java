package com.bae.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.exceptions.FighterNotFoundException;
import com.bae.persistance.domain.Fighters;
import com.bae.persistance.repository.FighterRepository;

@Service
public class FighterService {

	private FighterRepository fighterRepo;
	
	private FighterService fighterService;
	
	public FighterService(FighterRepository fighterRepo) {
		this.fighterRepo = fighterRepo;
	}
	
	public List<Fighters> getAllFighters() {
		return fighterRepo.findAll();
	}
	
	public Fighters addNewFighter(Fighters fighter) {
		return fighterRepo.save(fighter);
	}
	
	public Fighters findFighterByID(Long fighterID) {
		return this.fighterRepo.findById(fighterID).orElseThrow(
				() -> new FighterNotFoundException());
				
	}
	
	public Fighters updateFighter(Fighters fighter, Long fighterID) {
		Fighters toUpdate = findFighterByID(fighterID);
		toUpdate.setFirstName(fighter.getFirstName());
		toUpdate.setLastName(fighter.getLastName());
		toUpdate.setHeight(fighter.getHeight());
		toUpdate.setWeight(fighter.getWeight());
		return this.fighterRepo.save(toUpdate);
	}
	
	public Fighters changeWeightOfFighter(Long fighterID, Fighters fighter) {
		Fighters toUpdate = findFighterByID(fighterID);
		toUpdate.setWeight(fighter.getWeight());
		return this.fighterRepo.save(toUpdate);
	}
	
	public boolean deleteFighter(Long fighterID) {
		if (!this.fighterRepo.existsById(fighterID)) {
			throw new FighterNotFoundException();
		}
		
		this.fighterRepo.deleteById(fighterID);
		return this.fighterRepo.existsById(fighterID);
	}
	
	
}
