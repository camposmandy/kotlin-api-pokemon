package br.com.amandacampos.pokemon.model.pokeapi

import com.fasterxml.jackson.annotation.JsonProperty

data class PokemonSpecie(@JsonProperty("name") val name: String)