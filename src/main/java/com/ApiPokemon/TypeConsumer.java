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

import com.ApiPokemon.Type.TypeBean;
import com.ApiPokemon.Type.TypesBoot;

@Configuration
public class TypeConsumer {
	
	private static final String endpoint = "https://pokeapi.co/api/v2/type/";
	
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate;
	}
	
	public TypesBoot getTypesBoot() {
		HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", 
        		"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<TypesBoot> resp = restTemplate().exchange(endpoint, HttpMethod.GET, entity, TypesBoot.class);
		return resp.getBody();
	}
	
	@Cacheable(value = "poketipos")
	public List<TypeBean> getTypes(){
		
		List<TypeBean> types = new ArrayList<TypeBean>();
		TypesBoot tb = getTypesBoot();
		for( HashMap<String, String> tbean : tb.getResults()) {
			String typeUrl = tbean.get(TypesBoot.urlResults);
			HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
	        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	        ResponseEntity<TypeBean> resp = restTemplate().exchange(typeUrl, HttpMethod.GET,entity,TypeBean.class);
	        types.add(resp.getBody());
		}
		return types;
	}

}
