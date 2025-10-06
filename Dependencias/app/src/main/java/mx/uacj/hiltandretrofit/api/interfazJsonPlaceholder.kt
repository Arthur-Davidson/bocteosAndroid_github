package mx.uacj.hiltandretrofit.api

import mx.uacj.hiltandretrofit.modelos.Publicacion
import retrofit2.http.GET

interface JSONPlaceholder {
    @GET("/posts")
    suspend fun obtener_publicaciones(): List<Publicacion>
}