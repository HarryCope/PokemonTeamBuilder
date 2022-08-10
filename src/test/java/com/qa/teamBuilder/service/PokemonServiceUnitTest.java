package com.qa.teamBuilder.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.teamBuilder.models.Pokemon;
import com.qa.teamBuilder.repo.PokemonRepo;
import com.qa.teamBuilder.service.PokemonService;

@SpringBootTest(webEnvironment = WebEnvironment.MOCK)
public class PokemonServiceUnitTest {

		@Autowired
		private PokemonService service;
		
		@MockBean
		private PokemonRepo repo;
		
		@Test
		public void createPokemon_ValidPokemon_SavePokemon() {
			
			Pokemon savePokemon = new Pokemon("Pikachu", "Electric", 50, "Focus Sash");
			Pokemon repoPokemon = new Pokemon(1L, "Pikachu", "Electric", 50, "Focus Sash");

			Mockito.when(this.service.createPokemon(savePokemon)).thenReturn(repoPokemon);
			assertEquals(repoPokemon, this.repo.save(savePokemon));
			Mockito.verify(this.repo, Mockito.times(1)).save(savePokemon);
			
			
		}
		
		@Test
		public void updatePokemon_ValidId_UpdatePokemon() {
			
			Long testId = 1L;
			Pokemon updatePokemon = new Pokemon("Articuno", "Ice/Flying", 100, "Life Orb");
			
			Optional<Pokemon> mockOutputValid = Optional.ofNullable(new Pokemon(1L, "Pickachu", "Electric", 50, "Focus Sash"));
			Pokemon expectedOutput = new Pokemon(1L, "Pikachu", "Electric", 50, "Focus Sash");
			
			Mockito.when(this.repo.findById(testId)).thenReturn(mockOutputValid);
			Mockito.when(this.repo.save(expectedOutput)).thenReturn(expectedOutput);

			assertEquals(expectedOutput, this.service.updatePokemon(expectedOutput, 1L));
			
			Mockito.verify(this.repo, Mockito.times(1)).save(expectedOutput);
			Mockito.verify(this.repo, Mockito.times(1)).findById(testId);		
		}

	}