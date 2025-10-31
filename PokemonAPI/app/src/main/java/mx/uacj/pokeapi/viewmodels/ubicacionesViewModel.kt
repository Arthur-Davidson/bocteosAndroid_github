package mx.uacj.pokeapi.viewmodels

import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mx.uacj.pokeapi.modelos.Ubicacion
import mx.uacj.pokeapi.repositorioAPI.apiConexion.interfazUbicacionesAPI
import mx.uacj.pokeapi.repositorioAPI.repositorioUbicaciones
import javax.inject.Inject

@HiltViewModel
class UbicacionesViewModel @Inject constructor(
    private val repositorio: repositorioUbicaciones,
    private val conexionAPI: interfazUbicacionesAPI
) : ViewModel() {

    val ubicaciones: State<List<Ubicacion>> = repositorio.ubicaciones

    init {
        cargarUbicaciones()
    }

    private fun cargarUbicaciones() {
        for (id in 1..50) {
            viewModelScope.launch {
                try {
                    val ubicacion = conexionAPI.descargarUbicacion(id)
                    repositorio.agregarUbicacion(ubicacion)
                } catch (_: Exception) { }
            }
        }
    }
}
