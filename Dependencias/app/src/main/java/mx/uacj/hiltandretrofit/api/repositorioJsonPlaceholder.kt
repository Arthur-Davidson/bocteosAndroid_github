package mx.uacj.hiltandretrofit.api

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Constructor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

// Funciona como una clase estatica
object ServidorJSONPlaceholder {
    @Provides
    @Singleton
    fun CreaConsultasDeServicio(constructor: Retrofit.Builder): JSONPlaceholder {
        return constructor
            .build()
            .create(JSONPlaceholder::class.java)
    }

    // Cualquier cosa que necesite conexion llamara a CreaConsultaDeSErvicio(ProveeConexionAPlaceholder)
    @Provides
    @Singleton
    fun ProveeConexionAlPlaceholder(): Retrofit.Builder{
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
    }
}