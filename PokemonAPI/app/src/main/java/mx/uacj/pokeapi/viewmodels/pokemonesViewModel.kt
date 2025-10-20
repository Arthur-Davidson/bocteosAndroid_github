package mx.uacj.pokeapi.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mx.uacj.pokeapi.modelos.pokemon
import mx.uacj.pokeapi.repositorioAPI.apiConexion.interfazPokemonAPI
import mx.uacj.pokeapi.repositorioAPI.repositorioPokemones
import okhttp3.internal.toImmutableList
import javax.inject.Inject

@HiltViewModel
class pokemonesViewModel @Inject constructor(
    private val repositorio: repositorioPokemones,
    private val conexionServer: interfazPokemonAPI
): ViewModel() {
    private var estado = mutableStateOf("Cargando")
    public val pokemones: State<List<pokemon>> = repositorio.pokemones

    init {
        for (indicePokemon in 0 .. 100) {
            descargarPokemon(indicePokemon)
        }

    }

    fun descargarPokemon(id: Int): pokemon {
        val pokemon: pokemon
        viewModelScope.launch {
            pokemon = conexionServer.descargarPokemon(id)
            //



            val primerPokemon = conexionServer.descargarPokemon(id)
            //pokemonCache = mutableStateOf(pokemonDescargado)
        }
        return pokemon
    }
}