package com.qa.teamBuilder.modelsTest;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.qa.teamBuilder.models.Pokemon;

//import nl.jqno.equalsverifier.EqualsVerifier;

@TestInstance(Lifecycle.PER_CLASS)
public class PokemonTest {
	

	static Pokemon testPokemon;

	@BeforeAll
	public static void buildPokemon() {
		System.out.println("Building Pokemon");
		testPokemon = new Pokemon(1L, "Pikachu", "Electric", 50, "Focus Sash");
	}

	@Test
	public void constructors_Pokemon_Pokemon() {
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
	public void constructors_Pokemon_PokemonWithId() {
		Pokemon pokemonOne = new Pokemon();

		assertTrue(pokemonOne instanceof Pokemon == true);

		Pokemon pokemonTwo = new Pokemon(1L, "Articuno", "Ice/Flying", 100, "Life Orb");

		assertTrue(pokemonTwo instanceof Pokemon == true);
		assertEquals(1L, pokemonTwo.getPokemonId());
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

	@Test
    public void setIdTest() throws NoSuchFieldException, IllegalAccessException {
        Pokemon testEntry = new Pokemon(4L, null, null, 0, null);
        testEntry.setPokemonId(5L);

       Field expected = testEntry.getClass().getDeclaredField("pokemon_id");
        expected.setAccessible(true);
        assertEquals(expected.get(testEntry), 5L);
    }
	
	@Test
    public void setHeldItemTest() throws NoSuchFieldException, IllegalAccessException {
        Pokemon testEntry = new Pokemon(4L, null, null, 0, "focus sash");
        testEntry.setHeldItem("choice specs");

       Field expected = testEntry.getClass().getDeclaredField("held_item");
        expected.setAccessible(true);
        assertEquals(expected.get(testEntry), "choice specs");
    }
	
	@Test
    public void setNameTest() throws NoSuchFieldException, IllegalAccessException {
        Pokemon testEntry = new Pokemon(4L, "pikachu", null, 0, null);
        testEntry.setName("Zapdos");

       Field expected = testEntry.getClass().getDeclaredField("name");
        expected.setAccessible(true);
        assertEquals(expected.get(testEntry), "Zapdos");
    }
	
	@Test
    public void setTypeTest() throws NoSuchFieldException, IllegalAccessException {
        Pokemon testEntry = new Pokemon(4L, "pikachu", "Electric", 0, null);
        testEntry.setType("Water");

       Field expected = testEntry.getClass().getDeclaredField("type");
        expected.setAccessible(true);
        assertEquals(expected.get(testEntry), "Water");
    }
	
	@Test
    public void setLevelTest() throws NoSuchFieldException, IllegalAccessException {
        Pokemon testEntry = new Pokemon(4L, null, null, 54, null);
        testEntry.setLevel(50);

       Field expected = testEntry.getClass().getDeclaredField("level");
        expected.setAccessible(true);
        assertEquals(expected.get(testEntry), 50);
    }
	
	
}



