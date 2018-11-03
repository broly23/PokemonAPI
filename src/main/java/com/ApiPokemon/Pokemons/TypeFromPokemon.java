package com.ApiPokemon.Pokemons;

import java.io.Serializable;
import java.util.HashMap;

public class TypeFromPokemon implements Serializable {
	
	public static final String nomeType = "name";
	public static final String urlType = "url";
	
	private HashMap<String, String> type = new HashMap<String,String>();
	private Integer slot;
	
	public HashMap<String, String> getType() {
		return type;
	}
	public void setType(HashMap<String, String> type) {
		this.type = type;
	}
	public Integer getSlot() {
		return slot;
	}
	public void setSlot(Integer slot) {
		this.slot = slot;
	}
	
	
}
