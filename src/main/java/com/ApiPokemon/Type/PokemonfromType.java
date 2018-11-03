package com.ApiPokemon.Type;

import java.io.Serializable;
import java.util.HashMap;

public class PokemonfromType implements Serializable {

	public static final String nomePokemon = "name";
	public static final String urlPokemon = "url";
	
	private HashMap<String, String> pokemon = new HashMap<String,String>();
	private Integer slot;
	
	public HashMap<String, String> getPokemon() {
		return pokemon;
	}
	public void setPokemon(HashMap<String, String> pokemon) {
		this.pokemon = pokemon;
	}
	public Integer getSlot() {
		return slot;
	}
	public void setSlot(Integer slot) {
		this.slot = slot;
	}
	
}
