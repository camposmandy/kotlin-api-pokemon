package br.com.amandacampos.pokemon

import br.com.amandacampos.pokemon.connector.SapHanaConnector
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class App

fun main(args: Array<String>) {
    val sapHanaConnector: SapHanaConnector = SapHanaConnector()
    SpringApplication.run(App::class.java, *args)
    sapHanaConnector.databaseConnector()
}
