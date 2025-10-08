package mx.uacj.hiltandretrofit.ui.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import mx.uacj.hiltandretrofit.controlador.ControladorPublicaciones

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier,
             ControlPublicaciones: ControladorPublicaciones = hiltViewModel()
) {
    ControlPublicaciones.obtenerPublicaciones()

    if (ControlPublicaciones.publicaciones.value.size > 0){
        Column (modifier = Modifier.verticalScroll(rememberScrollState())) {
            for (publicacion in ControlPublicaciones.publicaciones.value){
                Text("Publicacion: ${publicacion.title}")
                Text("${publicacion.body}")
            }
        }
    }
    else {
        Text("Disculpa las molestias, pero estamos obteniendo las ultimas publicaciones. Favores de esperar...")
    }

    Text(
        text = "Tenemos la cantidad de ${ControlPublicaciones.publicaciones.value.size} publicaciones",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun Previsualizacion(){
    Greeting("Mundo")
}