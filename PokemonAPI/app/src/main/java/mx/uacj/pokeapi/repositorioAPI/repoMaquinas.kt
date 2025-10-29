package mx.uacj.pokeapi.repositorioAPI

import androidx.compose.runtime.mutableStateOf
import mx.uacj.pokeapi.modelos.Maquina
import javax.inject.Inject
import javax.inject.Singleton
import java.util.Collections.emptyList

@Singleton
class repositorioMaquinas @Inject constructor() {
    val maquinas = mutableStateOf<List<Maquina>>(emptyList())
}
