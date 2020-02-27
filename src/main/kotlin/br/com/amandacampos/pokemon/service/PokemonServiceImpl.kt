package br.com.amandacampos.pokemon.service

import br.com.amandacampos.pokemon.connector.ReactiveServerConnector
import br.com.amandacampos.pokemon.exception.PokemonNotFoundException
import  br.com.amandacampos.pokemon.model.Pokemon
import br.com.amandacampos.pokemon.model.pokeapi.PokemonBase
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.doOnError
import java.lang.Exception
import java.lang.RuntimeException

@Service
class PokemonServiceImpl: PokemonService {
    private val URL_BASE_POKEAPI = "https://pokeapi.co/api/v2/"
    private val connector: ReactiveServerConnector = ReactiveServerConnector(URL_BASE_POKEAPI)

    override fun save(pokemon: Pokemon): Mono<Pokemon> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Throws(PokemonNotFoundException::class)
    override fun findById(id: Long): Mono<Pokemon> {
         val URL = URL_BASE_POKEAPI + "pokemon/" + id

            return connector.doGet(URL)
                    .flatMap { it.bodyToMono(PokemonBase::class.java) }
                    .doOnError { throw PokemonNotFoundException("Pokemon not found, try another id") }
                    .map { pokemon: PokemonBase? ->

                            Pokemon(pokemon!!.id.toLong(),
                                pokemon.name,
                                getType(pokemon),
                                getAbilities(pokemon))
                    }
    }

    @Throws(PokemonNotFoundException::class)
    override fun findByName(name: String): Mono<Pokemon> {
        val URL = URL_BASE_POKEAPI + "pokemon/" + name
        return connector.doGet(URL)
                .flatMap {it.bodyToMono(PokemonBase::class.java) }
                .doOnError { throw PokemonNotFoundException("Pokemon not found") }
                .map { pokemon: PokemonBase? ->

                    Pokemon(
                            pokemon!!.id.toLong(),
                            pokemon.name,
                            getType(pokemon),
                            getAbilities(pokemon)
                    )}
    }

    override fun findAll(): Flux<Pokemon> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(id: Long): Mono<Void> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun getAbilities(pokemon: PokemonBase): List<String> {
        return pokemon.abilities.map { it.ability.name }
    }

    private fun getType(pokemon: PokemonBase): String {
        if (pokemon.types.isNotEmpty()) {
            return pokemon.types[0].type.name
        }
        return "not-found"
    }
}