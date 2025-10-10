package mx.uacj.hiltandretrofit.ui.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import mx.uacj.hiltandretrofit.controlador.ControladorPublicaciones

@Composable
fun PantallaPublicacion(
    modificador: Modifier = Modifier,
    controladorPublicaciones: ControladorPublicaciones = hiltViewModel()
){
    controladorPublicaciones.obtenerPublicaciones()
    controladorPublicaciones.seleccionarPublicacion(1)

    val publicacion = controladorPublicaciones.publicacionSeleccionada.value
    val comentarios = controladorPublicaciones.comentarios

    Column (modificador) {
        Text("Titulo: ${publicacion.title}")
        Text("Cuerpo: ${publicacion.body}")
    }
}