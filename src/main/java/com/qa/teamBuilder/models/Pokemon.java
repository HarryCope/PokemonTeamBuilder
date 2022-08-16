package com.qa.teamBuilder.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity	
public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pokemon_id;
	
	@Column(nullable = false )
	private String name;
	
	@Column
	private String held_item;
	
	@Column(nullable = false )
	private String type;
	
	//@Min(1)
	//@Max(100)
	@Column
	private int level;
	
	
	
	public Pokemon() {
		
	}

	public Pokemon(Long pokemon_id, String name, String type, int level, String held_item) {
		super();
		this.pokemon_id = pokemon_id;
		this.name = name;
		this.type = type;
		this.level = level;
		this.held_item = held_item;
	}

	public Pokemon( String name,  String type, int level, String held_item) {
		super();
		this.name = name;
		this.type = type;
		this.level = level;
		this.held_item = held_item;
	}

	public Long getPokemonId() {
		return pokemon_id;
	}

	public void setPokemonId(Long pokemonId) {
		this.pokemon_id = pokemonId;
	}
	
	public String getHeldItem() {
		return held_item;
	}

	public void setHeldItem(String held_item) {
		this.held_item = held_item;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public int hashCode() {
		return Objects.hash(level, name,  type, held_item);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pokemon other = (Pokemon) obj;
		return level == other.level && Objects.equals(name, other.name) && Objects.equals(type, other.type) && Objects.equals(held_item, other.held_item);
	}

	@Override
	public String toString() {
		return "Pokemon [pokemonId= " + pokemon_id + ", name= " + name + ", type= " + type + ", level= " + level + ", held item= " + held_item + "]";
	}
	
	
}