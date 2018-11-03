package com.ApiPokemon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ApiPokemon.Pokemons.Pokemon;
import com.ApiPokemon.Type.TypeBean;
import com.google.gson.Gson;

@RestController
public class PokemonController {
	
	@Autowired
	TypeConsumer typeConsumer;
	
	@RequestMapping(value = "/types")
	public List<TypeBean> getType() {
		return typeConsumer.getTypes();
	}
	
	@RequestMapping(value = "/type/{name}")
	public String getTypeName(@PathVariable("name") String feature) {
		Gson gson = new Gson();
		for (TypeBean temp : typeConsumer.getTypes()) {
			if (temp.getName().equalsIgnoreCase(feature.trim())) {
				return gson.toJson(temp);
			}
		}
		return "Nenhum tipo encontrado com esse nome: " + feature;
	}
	
	@Autowired
	PokemonConsumer pokemonConsumer;
	
	@RequestMapping(value = "/pokemons")
	public List<Pokemon> getPokemon() {
		return pokemonConsumer.getPokemon();
	}
	
	@RequestMapping(value = "/pokemon/{name}")
	public String getPokemonName(@PathVariable("name") String feature) {

		Gson gson = new Gson();
		for (Pokemon temp : pokemonConsumer.getPokemon()) {
			if (temp.getName().equalsIgnoreCase(feature.trim())) {
				return gson.toJson(temp);
		}
	}	
		return "Nenhum pokémon encontrado com esse nome: " + feature;
		
}
}
