package com.qa.teamBuilder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.teamBuilder.models.Pokemon;
import com.qa.teamBuilder.repo.PokemonRepo;

@Service
public class PokemonService {
	
	private Pokemon pokemon;
	@Autowired
	private PokemonRepo repo;
	
	@Autowired
	public PokemonService(PokemonRepo repo) {
		this.repo = repo;
		pokemon = new Pokemon();
		
	}
	
	public Pokemon createPokemon(Pokemon pokemon) {
		return repo.save(pokemon);
	}
	
	public List<Pokemon> createManyPokemon(List<Pokemon> pokemon) {
		return repo.saveAll(pokemon);
	}
	
	public boolean deletePokemon(Long id) {
		Optional<Pokemon> currentPokemon = this.repo.findById(id);
		
		boolean isPresent = (currentPokemon.isPresent()) ? true : false;
		
		if (isPresent) {
			this.repo.deleteById(id);
			return true;
		} else {
			return false;
		}
		
	}
	
	public Pokemon updatePokemon(Pokemon updatePokemon, Long id) {  
		Optional<Pokemon> currentPokemon = this.repo.findById(id);
	
		if (currentPokemon.get() instanceof Pokemon) {
			Pokemon oldPokemon = currentPokemon.get();
			
			oldPokemon.setType(updatePokemon.getType());
			oldPokemon.setName(updatePokemon.getName());
			oldPokemon.setHeldItem(updatePokemon.getHeldItem());
			oldPokemon.setLevel(updatePokemon.getLevel());
			return repo.save(oldPokemon);
		}
		
		return null;
	}
	
	public List<Pokemon> readAllPokemon() {      
		return this.repo.findAll();  
	}  
	
	public Pokemon readPokemon(Long id) {  
		return repo.findById(id).get();  
	}  
}

