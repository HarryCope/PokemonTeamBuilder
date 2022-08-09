package com.qa.teamBuilder.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.teamBuilder.models.Pokemon;

@Repository
public class PokemonRepo {

	public interface CatRepo extends JpaRepository<Pokemon, Long> {
		
		
	}
	
	
}
