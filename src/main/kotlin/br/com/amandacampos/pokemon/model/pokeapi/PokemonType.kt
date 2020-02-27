package br.com.amandacampos.pokemon.model.pokeapi

import com.fasterxml.jackson.annotation.JsonProperty

data class PokemonType (@JsonProperty("type") val type: PokemonSpecie)