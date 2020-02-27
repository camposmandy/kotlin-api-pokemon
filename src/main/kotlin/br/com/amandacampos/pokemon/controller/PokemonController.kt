package br.com.amandacampos.pokemon.controller

import br.com.amandacampos.pokemon.model.Pokemon
import br.com.amandacampos.pokemon.service.PokemonServiceImpl
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class PokemonController {

    private val pokemonService: PokemonServiceImpl = PokemonServiceImpl()

    @GetMapping
    fun findPokemonByName(@RequestParam name: String): Mono<Pokemon> {
        return pokemonService.findByName(name)
    }
}