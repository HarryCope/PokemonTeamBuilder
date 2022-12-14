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
	
	
	public boolean deletePokemon(Long pokemonId) {
		Optional<Pokemon> currentPokemon = this.repo.findById(pokemonId);
		
		boolean isPresent = (currentPokemon.isPresent()) ? true : false;
		
		if (isPresent) {
			this.repo.deleteById(pokemonId);
			return true;
		} else {
			return false;
		}
		
	}
	
	public Pokemon updatePokemon(Pokemon updatePokemon, Long pokemonId) {  
		Optional<Pokemon> currentPokemon = this.repo.findById(pokemonId);
	
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
		return repo.findAll();  
	}  
	
	public Pokemon readPokemon(Long pokemonId) {  
		return repo.findById(pokemonId).get();  
	}  
}

