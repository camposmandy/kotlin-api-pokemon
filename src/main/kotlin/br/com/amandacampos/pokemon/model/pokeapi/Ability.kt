package br.com.amandacampos.pokemon.model.pokeapi

import com.fasterxml.jackson.annotation.JsonProperty

data class Ability(@JsonProperty("name") val name: String)