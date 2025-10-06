package mx.uacj.navigationcompose.ui.controladores.navegacion

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import mx.uacj.navigationcompose.ui.pantallas.PantallaInicio
import mx.uacj.navigationcompose.ui.pantallas.PantallaVideo

// Constantes de rutas
const val INICIO = "Inicio"
const val VIDEO = "Video"
const val CONFIGURACION = "Configuracion"
const val CANAL = "Canal"

@Composable
fun NavegacionInicio(
    modificador: Modifier = Modifier,
    controladorDeNavegacion: NavHostController
) {
    NavHost(
        navController = controladorDeNavegacion,
        startDestination = INICIO
    ) {
        composable(INICIO) {
            PantallaInicio(modificador, controladorDeNavegacion)
        }

        composable(VIDEO) {
            PantallaVideo(modificador, controladorDeNavegacion)
        }

        composable(CONFIGURACION) {
            Column(
                modifier = modificador
                    .fillMaxSize()
                    .background(color = Color.Cyan)
            ) {
                Text("En pantalla de configuración")

                Text(
                    "Ir a Video",
                    modifier = Modifier
                        .padding(15.dp)
                        .clickable {
                            controladorDeNavegacion.navigate(VIDEO)
                        }
                )

                Text(
                    "Ir a Inicio",
                    modifier = Modifier
                        .padding(15.dp)
                        .clickable {
                            controladorDeNavegacion.popBackStack()
                        }
                )

                Text(
                    "Ir a Canal",
                    modifier = Modifier
                        .padding(15.dp)
                        .clickable {
                            controladorDeNavegacion.navigate(CANAL)
                        }
                )
            }
        }

        composable(CANAL) {
            Text(
                "En pantalla de canal",
                modifier = modificador
                    .fillMaxSize()
                    .background(color = Color.Green)
            )
        }
    }
}
