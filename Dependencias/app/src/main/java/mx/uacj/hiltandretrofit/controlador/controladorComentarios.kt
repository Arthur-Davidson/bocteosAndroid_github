package mx.uacj.hiltandretrofit.controlador

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mx.uacj.hiltandretrofit.api.JSONPlaceholder
import mx.uacj.hiltandretrofit.modelos.Publicacion
import java.util.Collections.emptyList
import javax.inject.Inject

@HiltViewModel
class ControladorPublicaciones @Inject constructor(
            private val apiPlaceholder: JSONPlaceholder
): ViewModel(){
    private val _publicaciones = mutableStateOf(emptyList<Publicacion>())
    val publicaciones: State<List<Publicacion>> = _publicaciones

    fun obtenerPublicaciones(){
        viewModelScope.launch {
            try {
                val publicacionesObtenidas = apiPlaceholder.obtener_publicaciones()
                _publicaciones.value = publicacionesObtenidas
            }
            catch (error: Exception) {
                Log.wtf("Peticion API", "La api respondio con un ${error.message}")
            }
        }
    }
}