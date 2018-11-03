package com.ApiPokemon.Pokemons;

import com.ApiPokemon.Type.DamageRelations;

public class TypeFromPokemonCustom extends TypeFromPokemon{

	private static final long serialVersionUID = 1L;
	
	private DamageRelations damageRelations;
	
	public TypeFromPokemonCustom( TypeFromPokemon tp ) {
		super.setSlot(tp.getSlot());
		super.setType(tp.getType());
	}

	public DamageRelations getDamageRelations() {
		return damageRelations;
	}

	public void setDamageRelations(DamageRelations damageRelations) {
		this.damageRelations = damageRelations;
	}
	
	

}
