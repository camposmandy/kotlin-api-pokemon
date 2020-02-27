package br.com.amandacampos.pokemon.model.dao

import org.jdbi.v3.sqlobject.statement.SqlUpdate

interface PokemonDao {
        @SqlUpdate("CREATE TABLE pokemon (id INTEGER PRIMARY KEY, name VARCHAR)")
        fun createTable(): Unit {};
}