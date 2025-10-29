package mx.uacj.pokeapi.repositorioAPI.apiConexion

import mx.uacj.pokeapi.modelos.pokemon
import mx.uacj.pokeapi.modelos.Maquina
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface interfazPokemonAPI{

    @GET("pokemon/{id}")
    suspend fun descargarPokemon(@Path("id") id: Int): pokemon

    // Ampliacion de maquinas
    @GET("machine/{id}")
    suspend fun descargarMaquina(@Path("id") id: Int): Maquina

}