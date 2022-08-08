package com.qa.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity	
public class Pokemon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long pokemonId;
	
	@NotNull
	private String name;
	
	@NotNull
	private String type;
	
	@Min(1)
	@Max(100)
	private int level;
	
	public Pokemon() {
		
	}

	public Pokemon(Long pokemonId, @NotNull String name, @NotNull String type, @Min(1) @Max(100) int level) {
		super();
		this.pokemonId = pokemonId;
		this.name = name;
		this.type = type;
		this.level = level;
	}

	public Pokemon(@NotNull String name, @NotNull String type, @Min(1) @Max(100) int level) {
		super();
		this.name = name;
		this.type = type;
		this.level = level;
	}

	public Long getPokemonId() {
		return pokemonId;
	}

	public void setPokemonId(Long pokemonId) {
		this.pokemonId = pokemonId;
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
		return Objects.hash(level, name, pokemonId, type);
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
		return level == other.level && Objects.equals(name, other.name) && Objects.equals(pokemonId, other.pokemonId)
				&& Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "Pokemon [pokemonId= " + pokemonId + ", name= " + name + ", type= " + type + ", level= " + level + "]";
	}
	
	
}
