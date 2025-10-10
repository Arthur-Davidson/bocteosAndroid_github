package mx.uacj.hiltandretrofit.controlador

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mx.uacj.hiltandretrofit.api.JSONPlaceholder
import mx.uacj.hiltandretrofit.modelos.Comentario
import mx.uacj.hiltandretrofit.modelos.Publicacion
import java.util.Collections.emptyList
import javax.inject.Inject

@HiltViewModel
class ControladorPublicaciones @Inject constructor(
            private val apiPlaceholder: JSONPlaceholder
): ViewModel(){
    private val _publicaciones = mutableStateOf(emptyList<Publicacion>())
    val publicaciones: State<List<Publicacion>> = _publicaciones

    private val _publicacionSeleccionada = mutableStateOf(Publicacion(id = 0, title = "404", body = "No encontrado", userId = 0))
    val publicacionSeleccionada: State<Publicacion> = _publicacionSeleccionada

    private val _comentarios = mutableStateOf(emptyList<Comentario>())
    val comentarios: State<List<Comentario>> = _comentarios


    fun obtenerPublicaciones(){
        viewModelScope.launch {
            try {
                val publicacionesObtenidas = apiPlaceholder.obtenerPublicaciones()
                _publicaciones.value = publicacionesObtenidas
            }
            catch (error: Exception) {
                Log.wtf("Peticion API", "La api respondio con un ${error.message}")
            }
        }
    }

    fun obtenerComentarios(){
        viewModelScope.launch {
            try {
                val comentariosObtenidos = apiPlaceholder.obtenerComentariosPublicacion(publicacionSeleccionada.value.id)
                _comentarios.value = comentariosObtenidos
            }
            catch (error: Exception) {
                Log.wtf("Peticion API", "La api respondio con un ${error.message}")
            }
        }
    }

    fun seleccionarPublicacion(id: Int) {
        for (publicacion in publicaciones.value) {
            if (publicacion.id == id){
                _publicacionSeleccionada.value = publicacion
                obtenerComentarios()
                break
            }
        }
    }
}