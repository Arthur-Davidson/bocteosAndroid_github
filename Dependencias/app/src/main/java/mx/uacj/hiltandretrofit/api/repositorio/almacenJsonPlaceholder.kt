package mx.uacj.hiltandretrofit.api.repositorio

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module

@InstallIn(SingletonComponent::class)

object prepararAlmacenJsonPlaceholder {
    @Provides
    @Singleton

    fun crearAlmacenPlaceholder(): interfazAlmacenPlaceholder {
        return almacenPlaceholder()
    }
}