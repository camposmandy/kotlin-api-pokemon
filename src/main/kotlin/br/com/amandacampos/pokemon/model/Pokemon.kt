package br.com.amandacampos.pokemon.model

data class Pokemon(
        val id: Long,
        val name: String,
        val type: String?,
        val abilities: List<String>)