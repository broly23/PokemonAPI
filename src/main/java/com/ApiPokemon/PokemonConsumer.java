package com.ApiPokemon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ApiPokemon.Pokemons.Pokemon;
import com.ApiPokemon.Pokemons.PokemonBoot;
import com.ApiPokemon.Pokemons.TypeFromPokemon;
import com.ApiPokemon.Pokemons.TypeFromPokemonCustom;
import com.ApiPokemon.Type.TypeBean;
import com.ApiPokemon.Type.TypesBoot;

@Configuration
public class PokemonConsumer {

	private static final String endpoint = "https://pokeapi.co/api/v2/pokemon/";

	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}

	public PokemonBoot getPokemonBoot() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<PokemonBoot> resp = restTemplate().exchange(endpoint, HttpMethod.GET, entity, PokemonBoot.class);
		return resp.getBody();
	}

	@Cacheable(value = "pokemons")
	public List<Pokemon> getPokemon() {

		List<Pokemon> pokemons = new ArrayList<Pokemon>();
		PokemonBoot pb = getPokemonBoot();
		for (HashMap<String, String> pboot : pb.getResults()) {
			String pokemonUrl = pboot.get(PokemonBoot.urlResults);
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.add("user-agent",
					"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			ResponseEntity<Pokemon> resp = restTemplate().exchange(pokemonUrl, HttpMethod.GET, entity, Pokemon.class);
			pokemons.add(resp.getBody());
			
			for(Pokemon p : pokemons) {
				List<TypeFromPokemonCustom> types = new ArrayList<TypeFromPokemonCustom>();
				
				for(TypeFromPokemon tp: p.getTypes()) {
					String typeUrl = tp.getType().get(TypeFromPokemon.urlType);;
					HttpHeaders headersTp = new HttpHeaders();
					headersTp.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
					headersTp.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
			        HttpEntity<String> entityTP = new HttpEntity<String>("parameters", headersTp);
			        ResponseEntity<TypeBean> respTp = restTemplate().exchange(typeUrl, HttpMethod.GET,entityTP,TypeBean.class);
			        
					TypeFromPokemonCustom tc = new TypeFromPokemonCustom(tp);
					tc.setDamageRelations(respTp.getBody().getDamageRelations());
					types.add(tc);
					
				}
				//p.setTypes(types);
			}
			
		}
		return pokemons;

	}

}
