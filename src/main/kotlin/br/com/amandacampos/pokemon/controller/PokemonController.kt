package br.com.amandacampos.pokemon.controller

import br.com.amandacampos.pokemon.model.Pokemon
import br.com.amandacampos.pokemon.service.PokemonServiceImpl
import org.jboss.logging.Param
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/pokemon")
class PokemonController {

    private val pokemonService: PokemonServiceImpl = PokemonServiceImpl()

    @GetMapping
    fun findPokemonByName(@RequestParam name: String): Mono<Pokemon> {
        return pokemonService.findByName(name)
    }

    @GetMapping(path = ["/{id}"])
    fun findPokemonById(@PathVariable id:Long): Mono<Pokemon> {
        return pokemonService.findById(id)
    }
}