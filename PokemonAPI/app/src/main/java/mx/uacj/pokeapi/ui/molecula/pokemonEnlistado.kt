package mx.uacj.pokeapi.ui.molecula

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.uacj.pokeapi.modelos.pokemon

@Composable
fun PokemonLista(pokemon: pokemon, modificador: Modifier = Modifier) {
    Card(
        modifier = modificador
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 10.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFF6666) // rojo claro
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "Nombre: ${pokemon.name}",
                color = Color(0xFFFFEB3B), // amarisho
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Altura: ${pokemon.height}",
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "Peso: ${pokemon.weight}",
                color = Color.White,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
