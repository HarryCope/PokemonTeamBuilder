package com.qa.teamBuilder.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.qa.teamBuilder.models.Pokemon;

	@Repository
	public interface PokemonRepo extends JpaRepository<Pokemon, Long> {
		
		@Query(value = "SELECT * FROM pokemon", nativeQuery = true)
		public List<Pokemon> readAllCats();
		
		@Query(value = "SELECT * FROM pokemon WHERE name = ?1", nativeQuery = true)
		public List<Pokemon> sameNameSelect(String name);
	}
	

