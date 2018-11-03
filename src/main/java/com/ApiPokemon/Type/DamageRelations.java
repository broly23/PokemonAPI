package com.ApiPokemon.Type;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DamageRelations implements Serializable {
	
	public static final String nomeDamage = "name";
	public static final String urlDamage = "url";

	@JsonProperty("double_damage_from")
	private List<HashMap<String, String>> doubleDamageFrom;
	@JsonProperty("double_damage_to")
	private List<HashMap<String, String>> doubleDamageTo;
	@JsonProperty("half_damage_from")
	private List<HashMap<String, String>> halfDamageFrom;
	@JsonProperty("half_damage_to")
	private List<HashMap<String, String>> halfDamageTo;
	@JsonProperty("no_damage_from")
	private List<HashMap<String, String>> noDamageFrom;
	@JsonProperty("no_damage_to")
	private List<HashMap<String, String>> noDamageTo;

	
	public List<HashMap<String, String>> getDoubleDamageFrom() {
		return doubleDamageFrom;
	}

	public void setDoubleDamageFrom(List<HashMap<String, String>> doubleDamageFrom) {
		this.doubleDamageFrom = doubleDamageFrom;
	}

	public List<HashMap<String, String>> getDoubleDamageTo() {
		return doubleDamageTo;
	}

	public void setDoubleDamageTo(List<HashMap<String, String>> doubleDamageTo) {
		this.doubleDamageTo = doubleDamageTo;
	}

	public List<HashMap<String, String>> getHalfDamageFrom() {
		return halfDamageFrom;
	}

	public void setHalfDamageFrom(List<HashMap<String, String>> halfDamageFrom) {
		this.halfDamageFrom = halfDamageFrom;
	}

	public List<HashMap<String, String>> getHalfDamageTo() {
		return halfDamageTo;
	}

	public void setHalfDamageTo(List<HashMap<String, String>> halfDamageTo) {
		this.halfDamageTo = halfDamageTo;
	}

	public List<HashMap<String, String>> getNoDamageFrom() {
		return noDamageFrom;
	}

	public void setNoDamageFrom(List<HashMap<String, String>> noDamageFrom) {
		this.noDamageFrom = noDamageFrom;
	}

	public List<HashMap<String, String>> getNoDamageTo() {
		return noDamageTo;
	}

	public void setNoDamageTo(List<HashMap<String, String>> noDamageTo) {
		this.noDamageTo = noDamageTo;
	}
	
}