package mx.uacj.pokeapi.repositorioAPI

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object repositorioOficial{
    @Provides
    @Singleton
    fun crearRepoParaGuadarPokemones(): repositorioPokemones{
        return almacenDatosPokemon()
    }
}