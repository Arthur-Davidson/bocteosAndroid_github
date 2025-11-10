package mx.uacj.hiltandretrofit.ui.controladores

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import mx.uacj.hiltandretrofit.ui.pantallas.ListaPublicaciones
import mx.uacj.hiltandretrofit.ui.pantallas.PantallaPublicacion
import mx.uacj.hiltandretrofit.ui.pantallas.PantallaPerfil

@Composable
fun NavegacionPrincipal(modificador: Modifier = Modifier) {
    val controlNavegacion = rememberNavController()

    NavHost(
        navController = controlNavegacion,
        startDestination = "listaPublicaciones"
    ) {
        // Lista de publicaciones
        composable("listaPublicaciones") {
            ListaPublicaciones(
                modificador,
                navegarAPublicacion = { publicacion ->
                    controlNavegacion.navigate("publicacion/${publicacion.id}/${publicacion.userId}")
                }
            )
        }

        // Pantalla de publicación
        composable(
            route = "publicacion/{postId}/{userId}",
            arguments = listOf(
                navArgument("postId") { type = NavType.IntType },
                navArgument("userId") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getInt("userId") ?: 0
            PantallaPublicacion(
                modificador,
                userId = userId,
                navegarAPerfil = { id ->
                    controlNavegacion.navigate("perfil/$id")
                }
            )
        }

        // Pantalla de perfil individual
        composable(
            route = "perfil/{userId}",
            arguments = listOf(navArgument("userId") { type = NavType.IntType })
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getInt("userId") ?: 0
            PantallaPerfil(userId = userId)
        }
    }
}
