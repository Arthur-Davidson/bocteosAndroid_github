package mx.uacj.pokeapi.repositorioAPI

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import mx.uacj.pokeapi.modelos.pokemon
import java.util.Collections.emptyList

class almacenDatosPokemon(
    override val pokemones: MutableState<List<pokemon>> = mutableStateOf(emptyList<pokemon>())
) :repositorioPokemones{}

interface repositorioPokemones {
    val pokemones: MutableState<List<pokemon>>
}