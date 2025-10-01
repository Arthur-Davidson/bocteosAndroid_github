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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.uacj.navigationcompose.ui.pantallas.PantallaVideo

@Composable
fun NavegacionInicio(modificador: Modifier = Modifier){
    val controladorNavegacion = rememberNavController()

    NavHost(navController = controladorNavegacion, startDestination = Inicio){
        composable <Inicio> {
            Column (modifier = modificador
                .fillMaxSize()
                .background(color = Color.Red)){

                Text("En pantalla de inicio")
                Text("Ir a Video",
                    modifier = modificador
                        .padding(15.dp)
                        .clickable { controladorNavegacion.navigate(Video) })

                Text("Ir a Configuracion",
                    modifier = modificador
                        .padding(15.dp)
                        .clickable { controladorNavegacion.navigate(Configuracion) })

                Text("Ir a Canal",
                    modifier = modificador
                        .padding(15.dp)
                        .clickable { controladorNavegacion.navigate(Canal) })
            }
        }

        composable <Video> {
            PantallaVideo(modificador, controladorNavegacion)
        }

        composable <Configuracion> {
            Text("En pantalla de configuracion", modifier = modificador
                .fillMaxSize()
                .background(color = Color.Green)
            )
            Text("Ir al inicio",
                modifier = modificador
                    .padding(15.dp)
                    .clickable { controladorNavegacion.navigate(Inicio) })
        }

        composable <Canal> {
            Text("En pantalla de canal", modifier = modificador
                .fillMaxSize()
                .background(color = Color.Yellow)
            )
            Text("Ir al inicio",
                modifier = modificador
                    .padding(15.dp)
                    .clickable { controladorNavegacion.navigate(Inicio) })
        }
    }
}