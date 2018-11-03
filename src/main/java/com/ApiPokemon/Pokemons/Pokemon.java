package com.ApiPokemon.Pokemons;

import java.io.Serializable;
import java.util.List;

public class Pokemon implements Serializable {

	private static final long serialVersionUID = 7812406077318897137L;
	private Integer height;
	private Integer id;
	private String name;
	private List<TypeFromPokemon> types;
	private Integer weight;

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TypeFromPokemon> getTypes() {
		return types;
	}

	public void setTypes(List<TypeFromPokemon> types) {
		this.types = types;
	}
	
	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}
