package br.com.amandacampos.pokemon.exception

import java.lang.RuntimeException

class PokemonNotFoundException : RuntimeException {
    constructor(message: String, ex: Exception?): super(message, ex) {}
    constructor(message: String): super(message) {}
    constructor(exception: Exception): super(exception) {}
}