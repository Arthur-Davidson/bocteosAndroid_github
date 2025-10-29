package mx.uacj.pokeapi.viewmodels

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mx.uacj.pokeapi.modelos.Maquina
import mx.uacj.pokeapi.repositorioAPI.apiConexion.interfazPokemonAPI
import mx.uacj.pokeapi.repositorioAPI.repositorioMaquinas
import javax.inject.Inject

@HiltViewModel
class MaquinasViewModel @Inject constructor(
    private val repositorio: repositorioMaquinas,
    private val conexionServer: interfazPokemonAPI
): ViewModel() {

    val maquinas: State<List<Maquina>> = repositorio.maquinas

    init {
        for (id in 1..100) {
            descargarMaquina(id)
        }
    }

    private fun descargarMaquina(id: Int) {
        viewModelScope.launch {
            try {
                val maquina = conexionServer.descargarMaquina(id)
                val lista = repositorio.maquinas.value.toMutableStateList()
                lista.add(maquina)
                repositorio.maquinas.value = lista
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
