package br.com.amandacampos.pokemon.model.pokeapi

import com.fasterxml.jackson.annotation.JsonProperty

data class PokemonAbility(
        @JsonProperty("is_hidden") val is_hidden: Boolean,
        @JsonProperty("ability") val ability: Ability)