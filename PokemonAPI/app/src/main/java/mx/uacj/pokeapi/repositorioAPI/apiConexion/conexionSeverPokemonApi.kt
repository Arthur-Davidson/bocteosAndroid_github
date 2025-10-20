package mx.uacj.pokeapi.repositorioAPI.apiConexion

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object conexionPokemonApi {
    @Provides
    @Singleton
    fun conexionServer(): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(" https://pokeapi.co/api/v2")
            .addConverterFactory((GsonConverterFactory.create()))
    }

    @Provides
    @Singleton
    fun enlaceConServidor(server: Retrofit.Builder): interfazPokemonAPI{
        return server.build()
            .create(interfazPokemonAPI::class.java)
    }
}