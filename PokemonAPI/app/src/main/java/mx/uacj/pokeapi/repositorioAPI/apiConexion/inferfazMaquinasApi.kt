package mx.uacj.pokeapi.repositorioAPI.apiConexion

import mx.uacj.pokeapi.modelos.Maquina
import retrofit2.http.GET
import retrofit2.http.Path

interface interfazMaquinasAPI {
    @GET("machine/{id}")
    suspend fun descargarMaquina(@Path("id") id: Int): Maquina
}
