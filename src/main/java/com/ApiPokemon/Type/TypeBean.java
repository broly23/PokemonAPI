package com.ApiPokemon.Type;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TypeBean implements Serializable {
	
	private static final long serialVersionUID = 7812406077318897137L;
	private String name;
	@JsonProperty("damage_relations")
	private DamageRelations damageRelations;
	private List<PokemonfromType> pokemon = new ArrayList<PokemonfromType>();

	public TypeBean() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public DamageRelations getDamageRelations() {
		return damageRelations;
	}

	public void setDamageRelations(DamageRelations damageRelations) {
		this.damageRelations = damageRelations;
	}

	public List<PokemonfromType> getPokemon() {
		return pokemon;
	}

	public void setPokemon(List<PokemonfromType> pokemon) {
		this.pokemon = pokemon;
	}

}
