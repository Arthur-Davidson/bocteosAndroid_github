package mx.uacj.pokeapi.ui.controladores

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import mx.uacj.pokeapi.ui.pantallas.pantallaPrincipal

// Modelo de datos para las opciones del menú inferior
data class OpcionesMenu(
    val titulo: String,
    val icono: String,
    val ruta: String
)

// Composable que dibuja la barra inferior con las opciones
@Composable
fun OpcionesMenuInferior(
    opciones: List<OpcionesMenu>,
    rutaActual: String,
    alPresionar: (String) -> Unit
) {
    // 🎨 Barra principal roja clara
    BottomAppBar(
        containerColor = Color(0xFF0D47A1), // rojo claro
        contentColor = Color.White,
        tonalElevation = 8.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(vertical = 6.dp)
        ) {
            for (opcion in opciones) {

                // Cada opción está dentro de un recuadro amarillo claro
                Card(
                    shape = RoundedCornerShape(12.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xFFFFF176) // amarillo claro
                    ),
                    modifier = Modifier
                        .clickable {
                            Log.v("NavegacionInferior", opcion.titulo)
                            alPresionar(opcion.ruta)
                        }
                ) {
                    Text(
                        text = opcion.titulo,
                        color = Color(0xFF0D47A1), // azul oscuro
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    )
                }
            }
        }
    }
}


// Composable principal con Scaffold
@Composable
fun MenuPrincipal() {

    val listaOpcionesMenu by remember {
        mutableStateOf(
            mutableStateListOf(
                OpcionesMenu("Pokemones", "icono", "PantallaPokemones"),
                OpcionesMenu("Ubicaciones", "icono", "PantallaUbicaciones"),
                OpcionesMenu("Máquinas", "icono", "PantallaMaquinas"),
            )
        )
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            OpcionesMenuInferior(
                opciones = listaOpcionesMenu,
                rutaActual = "TODO()", // placeholder
                alPresionar = { /* acción al presionar */ }
            )
        }
    ) { innerPadding ->
        pantallaPrincipal(modificador = Modifier.padding(innerPadding))
    }
}
