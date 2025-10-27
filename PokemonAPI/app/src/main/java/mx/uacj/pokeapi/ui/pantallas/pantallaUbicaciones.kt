package mx.uacj.pokeapi.ui.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.uacj.pokeapi.modelos.pokemon

// POR TERMINAR

@Composable
fun PantallaUbicaciones(modificador: Modifier = Modifier, pokemon: pokemon) {
    // Fondo
    Column(
        modifier = modificador
            .fillMaxSize()
            .background(Color(0xFFFFFDE7))
            .padding(16.dp)
    ) {
        // Simulación de imagen del pokemon centrada
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally // centra contenido horizontalmente
        ) {
            Box(
                modifier = Modifier
                    .size(200.dp) // cuadrado
                    .background(
                        color = Color(0xFF81D4FA),
                        shape = RoundedCornerShape(20.dp)
                    ),
                contentAlignment = Alignment.Center // centra contenido vertical y horizontal dentro del Box
            ) {
                Text(
                    text = "Imagen",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp
                )
            }
        }


        Spacer(modifier = Modifier.height(15.dp))

        // Recuadro para nombre y tipo
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFFF6666), // rojo claro
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Nombre: ${pokemon.name}",
                color = Color(0xFFFFEB3B), // amarillo
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            for (tipo in pokemon.types) {
                Text(
                    text = "Tipo: ${tipo.type.name}",
                    color = Color(0xFFFFEB3B),
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Stats
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFDCDCDC), // gris claro
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(16.dp)
        ) {
            for (estadistica in pokemon.stats) {
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(
                        text = estadistica.stat.name,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF0D47A1)
                    )
                    Text(
                        text = "Base: ${estadistica.base_stat}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = "Esfuerzo: ${estadistica.effort}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Preview
@Composable
fun previewPantallaUbicaciones(){
    //
}