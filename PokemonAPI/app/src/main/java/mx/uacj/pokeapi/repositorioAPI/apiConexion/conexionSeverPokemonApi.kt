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

    private const val BASE_URL = "https://pokeapi.co/api/v2/"

    // Crea una única instancia de Retrofit que se comparte
    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Interfaz para Pokemones
    @Provides
    @Singleton
    fun providePokemonApi(retrofit: Retrofit): interfazPokemonAPI {
        return retrofit.create(interfazPokemonAPI::class.java)
    }

    // Interfaz para Máquinas
    @Provides
    @Singleton
    fun provideMaquinasApi(retrofit: Retrofit): interfazMaquinasAPI {
        return retrofit.create(interfazMaquinasAPI::class.java)
    }

    // Interfaz para Ubicaciones
    @Provides
    @Singleton
    fun provideUbicacionesApi(retrofit: Retrofit): interfazUbicacionesAPI {
        return retrofit.create(interfazUbicacionesAPI::class.java)
    }
}
