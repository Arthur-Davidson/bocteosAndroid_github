package mx.uacj.hiltandretrofit.api

import mx.uacj.hiltandretrofit.modelos.Comentario
import mx.uacj.hiltandretrofit.modelos.Publicacion
import mx.uacj.hiltandretrofit.modelos.Usuario
import retrofit2.http.GET
import retrofit2.http.Path

interface JSONPlaceholder {
    @GET("/posts")
    suspend fun obtenerPublicaciones(): List<Publicacion>

    @GET ("/posts/{id}/comments")
    suspend fun obtenerComentariosPublicacion(@Path("id")id: Int): List<Comentario>


    //Para obtener usuarios
    @GET("users")
    suspend fun obtenerUsuarios(): List<Usuario>

    @GET("users/{id}")
    suspend fun obtenerUsuarioPorId(@Path("id") id: Int): Usuario

}