package mx.uacj.navigationcompose.ui.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import mx.uacj.navigationcompose.ui.controladores.navegacion.Inicio

@Composable
fun PantallaVideo(modificador: Modifier = Modifier, controladorNavegacion:NavHostController){
    Text("En pantalla de videos", modifier = modificador
        .fillMaxSize()
        .background(color = Color.Blue)
    )
    Text("Ir al inicio",
        modifier = modificador
            .padding(15.dp)
            .clickable { controladorNavegacion.navigate(Inicio) })
}