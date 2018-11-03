package com.ApiPokemon.Pokemons;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class PokemonBoot implements Serializable {
	
	public static final String nomeResults = "name";
	public static final String urlResults = "url";

	private Integer count;
	private Object next;
	private Object previous;
	private List<HashMap<String, String>> results;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Object getNext() {
		return next;
	}

	public void setNext(Object next) {
		this.next = next;
	}

	public Object getPrevious() {
		return previous;
	}

	public void setPrevious(Object previous) {
		this.previous = previous;
	}

	public List<HashMap<String, String>> getResults() {
		return results;
	}

	public void setResults(List<HashMap<String, String>> results) {
		this.results = results;
	}
}
