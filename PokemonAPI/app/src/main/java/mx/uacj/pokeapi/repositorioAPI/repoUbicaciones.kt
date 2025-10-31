package mx.uacj.pokeapi.repositorioAPI

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import mx.uacj.pokeapi.modelos.Ubicacion
import java.util.Collections.emptyList
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class repositorioUbicaciones @Inject constructor() {
    private val _ubicaciones = mutableStateOf<List<Ubicacion>>(emptyList())
    val ubicaciones: State<List<Ubicacion>> get() = _ubicaciones

    fun agregarUbicacion(nueva: Ubicacion) {
        val lista = _ubicaciones.value.toMutableList()
        lista.add(nueva)
        _ubicaciones.value = lista
    }
}
