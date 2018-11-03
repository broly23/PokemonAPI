package com.ApiPokemon.Type;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Type implements Serializable {

	private String name;
	@JsonProperty("damage_relations")
	private DamageRelations damageRelations;

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

	
}