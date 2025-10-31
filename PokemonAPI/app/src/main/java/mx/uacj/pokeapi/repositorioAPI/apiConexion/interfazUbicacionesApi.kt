package mx.uacj.pokeapi.repositorioAPI.apiConexion

import mx.uacj.pokeapi.modelos.Ubicacion
import retrofit2.http.GET
import retrofit2.http.Path

interface interfazUbicacionesAPI {

    @GET("location/{id}")
    suspend fun descargarUbicacion(@Path("id") id: Int): Ubicacion
}
