package mx.uacj.pokeapi.ui.controladores

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import mx.uacj.pokeapi.ui.pantallas.pantallaPrincipal

data class OpcionesMenu(
    val titulo: String,
    val icono: String,
    val ruta: String
)

@Composable
fun OpcionesMenuInferior(
        opciones: List<OpcionesMenu>,
        rutaActual: String,
        alPresionar: () -> Unit
){
    BottomAppBar {
        Row {
            for (opcion in opciones) {
                Text("${opcion.titulo}", modifier = Modifier.clickable {
                    Log.v("NavegacionInferior", "${opcion.titulo}")
                })
            }
        }

    }
}

@Composable
fun MenuPrincipal() {

    val listaOpcionesMenu by remember { mutableStateOf(
        mutableStateListOf(
            OpcionesMenu("Pokemones", "icono", "PantallaPokemones"),
            OpcionesMenu("Ubicaciones", "icono", "PantallaPokemones"),
            OpcionesMenu("Maquinas", "icono", "PantallaPokemones"),
            )
        )
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {

        }
    ) { innerPadding ->
        pantallaPrincipal(modificador = Modifier.padding(innerPadding))
    }
}