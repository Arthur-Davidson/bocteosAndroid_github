package mx.uacj.hiltandretrofit.ui.pantallas

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import mx.uacj.hiltandretrofit.controlador.ControladorPublicaciones

@Composable
fun ListaPublicaciones(
    modifier: Modifier = Modifier,
    ControlPublicaciones: ControladorPublicaciones = hiltViewModel(),
    navegarAPublicacion: () -> Unit = {}
) {
    val controladorNavegacion = rememberNavController() // Para juntar el Nav Compose

    ControlPublicaciones.obtenerPublicaciones()

    if (ControlPublicaciones.publicaciones.value.size > 0){
        Column (modifier = Modifier.verticalScroll(rememberScrollState())) {
            for (publicacion in ControlPublicaciones.publicaciones.value){
                Column (modifier = Modifier.clickable {
                    ControlPublicaciones.seleccionarPublicacion(id = publicacion.id)
                    navegarAPublicacion()
                }) {
                    Text("Publicacion: ${publicacion.title}")
                    Text("${publicacion.body}")
                }
                Spacer(modifier = Modifier.height(50.dp))
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
    ListaPublicaciones()
}