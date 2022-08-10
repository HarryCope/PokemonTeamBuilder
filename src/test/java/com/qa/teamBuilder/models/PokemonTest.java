package com.qa.teamBuilder.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

//import nl.jqno.equalsverifier.EqualsVerifier;

@TestInstance(Lifecycle.PER_CLASS)
public class PokemonTest {
	

	static Pokemon testPokemon;

	@BeforeAll
	public static void buildPokemon() {
		System.out.println("Building Pokemon");
		testPokemon = new Pokemon(1L, "Pikachu", "Electric", 50, "Focus Sash");
	}

	//@Test
	//public void testEquals() {
	//	EqualsVerifier.simple().forClass(Pokemon.class).verify();
	//}

	@Test
	public void constructors_Pokemon_Pokemon() {
		// Create Cat
		Pokemon pokemonOne = new Pokemon();

		assertTrue(pokemonOne instanceof Pokemon == true);

		Pokemon pokemonTwo = new Pokemon("Articuno", "Ice/Flying", 100, "Life Orb");

		assertTrue(pokemonTwo instanceof Pokemon == true);
		assertEquals("Articuno", pokemonTwo.getName());
		assertEquals("Ice/Flying", pokemonTwo.getType());
		assertEquals(100, pokemonTwo.getLevel());
		assertEquals("Life Orb", pokemonTwo.getHeldItem());
	}

		
	@Test
	public void toString_String_PokemonInstance() {
		String expecting = "Pokemon [pokemonId= " + testPokemon.getPokemonId() + ", name= " + testPokemon.getName() + ", type= "
				+ testPokemon.getType() + ", level= " + testPokemon.getLevel() + ", held item= " + testPokemon.getHeldItem() + "]";

		assertEquals(expecting, testPokemon.toString());
	}

}

