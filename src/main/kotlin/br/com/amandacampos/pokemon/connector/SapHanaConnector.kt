package br.com.amandacampos.pokemon.connector

import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.sqlobject.SqlObjectPlugin

class SapHanaConnector {
    private val DATABASE_DRIVER = System.getenv("DATABASE_HOST")
    private val DATABASE_PORT = System.getenv("DATABASE_PORT")
    private val USER = System.getenv("DATABASE_USER");
    private val PASSWORD = System.getenv("DATABASE_PWD");


    fun databaseConnector() {
        val databaseConnectionString = "jdbc:sap://$DATABASE_DRIVER:$DATABASE_PORT?encrypt=true&user=$USER&password=$PASSWORD"
        val database = Jdbi.create(databaseConnectionString).installPlugin(SqlObjectPlugin())

//        database.withExtension<Exception>(PokemonDao::class.java) {
//            it.createTable();
//        }
    }
}
