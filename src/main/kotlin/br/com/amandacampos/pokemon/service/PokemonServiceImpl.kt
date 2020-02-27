package br.com.amandacampos.pokemon.service

import br.com.amandacampos.pokemon.connector.ReactiveServerConnector
import  br.com.amandacampos.pokemon.model.Pokemon
import br.com.amandacampos.pokemon.model.pokeapi.PokemonBase
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class PokemonServiceImpl: PokemonService {
    private val URL_BASE_POKEAPI = "https://pokeapi.co/api/v2/"
    private val connector: ReactiveServerConnector = ReactiveServerConnector(URL_BASE_POKEAPI)

    override fun save(pokemon: Pokemon): Mono<Pokemon> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findById(id: Long): Mono<Pokemon> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findByName(name: String): Mono<Pokemon> {
        val URL = URL_BASE_POKEAPI + "pokemon/" + name
        return connector.doGet(URL)
                .flatMap {it.bodyToMono(PokemonBase::class.java) }
                .map { pokemon: PokemonBase? ->

                    var type: String? = null

                    if (pokemon != null && pokemon.types.isNotEmpty()) {
                         type = pokemon.types[0].type.name
                    }

//                    val abilities: List<String> = pokemon!!.abilities.filter { it.ability.name }
                    Pokemon(
                            pokemon!!.id.toLong(),
                            pokemon.name,
                            type,
                            arrayListOf("")
                    )}
    }

    override fun findAll(): Flux<Pokemon> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(id: Long): Mono<Void> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}