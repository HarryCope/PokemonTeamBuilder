package com.qa.teamBuilder.controller;
	

	import java.util.List;

	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import com.qa.teamBuilder.models.Pokemon;
	import com.qa.teamBuilder.service.PokemonService;

	@RestController
	@RequestMapping("/home")
	public class PokemonController {
		
		PokemonService service;
		
		public PokemonController(PokemonService service) {
			this.service = service;
		}

		@GetMapping("/getPokemon")
		public ResponseEntity <List<Pokemon>> getPokemon() {
			List<Pokemon> pokemonData = service.readAllPokemon();
			return new ResponseEntity<List<Pokemon>>(pokemonData, HttpStatus.OK);
		}
		
		@PostMapping("/createPokemon")
		public ResponseEntity<Pokemon> createPokemon(@RequestBody Pokemon pokemon) {
			Pokemon createPokemon = service.createPokemon(pokemon);
			return new ResponseEntity<Pokemon>(createPokemon, HttpStatus.CREATED);
		}
		
		@PutMapping("/updatePokemon/{id}")
		public ResponseEntity<Pokemon> updatePokemon(@RequestBody Pokemon pokemon, Long id) {
			Pokemon updatePokemon = service.updatePokemon(pokemon, id);
			return new ResponseEntity<Pokemon>(updatePokemon, HttpStatus.OK);
		}
		
		@DeleteMapping("/deletePokemon/{id}")
		public ResponseEntity<Boolean> deletePokemon(Long id) {
			Boolean deletedPokemon = service.deletePokemon(id);
			return new ResponseEntity<Boolean>(deletedPokemon, HttpStatus.NO_CONTENT);
		}
	}

