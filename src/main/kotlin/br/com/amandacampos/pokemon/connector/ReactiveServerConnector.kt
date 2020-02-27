package br.com.amandacampos.pokemon.connector

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.client.ClientResponse
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class ReactiveServerConnector constructor(baseUrl: String = "http://localhost:8080") {

    @Autowired
    val client: WebClient = WebClient.create(baseUrl)

    fun doPost(url: String, request: Any): Mono<ClientResponse> {
        return  client.post()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(request))
                .exchange();
    }

    fun doGet(url: String): Mono<ClientResponse> {
        return  client.get()
                .uri(url)
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .exchange();
    }
}
