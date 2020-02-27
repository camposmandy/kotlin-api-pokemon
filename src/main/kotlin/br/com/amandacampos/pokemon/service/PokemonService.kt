package br.com.amandacampos.pokemon.service

import br.com.amandacampos.pokemon.model.Pokemon
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface PokemonService {
    fun save(pokemon: Pokemon): Mono<Pokemon>
    fun findById(id: Long): Mono<Pokemon>
    fun findByName(name: String): Mono<Pokemon>
    fun findAll(): Flux<Pokemon>
    fun delete(id: Long): Mono<Void>
}
