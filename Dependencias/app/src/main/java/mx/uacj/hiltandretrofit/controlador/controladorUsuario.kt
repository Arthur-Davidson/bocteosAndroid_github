package mx.uacj.hiltandretrofit.controlador

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import mx.uacj.hiltandretrofit.modelos.Usuario
import javax.inject.Inject
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import mx.uacj.hiltandretrofit.api.repositorio.RepositorioUsuarios


@HiltViewModel
class ControladorUsuarios @Inject constructor(
    private val repositorio: RepositorioUsuarios
) : ViewModel() {

    private val _usuarioSeleccionado = mutableStateOf<Usuario?>(null)
    val usuarioSeleccionado: State<Usuario?> = _usuarioSeleccionado

    fun obtenerUsuarioPorId(id: Int) {
        viewModelScope.launch {
            try {
                val usuario = repositorio.obtenerUsuarioPorId(id)
                _usuarioSeleccionado.value = usuario
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
