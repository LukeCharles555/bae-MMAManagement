package com.bae.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bae.persistance.domain.Fighters;
import com.bae.persistance.repository.FighterRepository;

@Service
public class FighterService {

	private FighterRepository fighterRepo;
	
	public FighterService(FighterRepository fighterRepo) {
		this.fighterRepo = fighterRepo;
	}
	
	public List<Fighters> getAllFighters() {
		if (fighterRepo.findAll().isEmpty()) {
			setUpFighters();
		}
		return fighterRepo.findAll();
	}
	
	private void setUpFighters() {
	}
	
	public Fighters addNewFighter(Fighters fighter) {
		return fighterRepo.save(fighter);
	}
	
	public Fighters updateFighter(Fighters fighter) {
		return fighterRepo.save(fighter);
	}
	
	public String deleteFighter(Long fighterID) {
		fighterRepo.deleteById(fighterID);
		return "Fighter successfully deleted";
	}
	
	
}
