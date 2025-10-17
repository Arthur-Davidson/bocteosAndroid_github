package mx.uacj.pokeapi.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class pokemonesViewModel @Inject constructor(
    private val repositorio: repositorioPokemones
): ViewModel() {
    private var estado = mutableStateOf("Cargando")

    fun descargar() {
        // Funcion para descargar api
    }
}