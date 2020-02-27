package br.com.amandacampos.pokemon.model.pokeapi

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
data class PokemonBase(
        @JsonProperty("id") val id: Int,
        @JsonProperty("name") val name: String,
        @JsonProperty("types") val types: List<PokemonType>,
        @JsonProperty("abilities") val abilities: List<PokemonAbility>)