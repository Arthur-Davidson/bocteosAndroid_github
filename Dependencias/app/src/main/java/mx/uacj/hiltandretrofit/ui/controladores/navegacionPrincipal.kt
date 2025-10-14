package mx.uacj.hiltandretrofit.ui.controladores

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.uacj.hiltandretrofit.ui.pantallas.ListaPublicaciones
import mx.uacj.hiltandretrofit.ui.pantallas.PantallaPublicacion


@Composable
fun NavegacionPrincipal(modificador: Modifier = Modifier){

    val controlNavegacion = rememberNavController()

    NavHost(navController = controlNavegacion, startDestination = PantallaListaPublicaciones) {
        composable<PantallaListaPublicaciones> {
            ListaPublicaciones(modificador, navegarAPublicacion = {controlNavegacion.navigate(PantallaPublicacion)})
        }
        composable<PantallaPublicacion> {
            PantallaPublicacion(modificador)
        }
    }
}