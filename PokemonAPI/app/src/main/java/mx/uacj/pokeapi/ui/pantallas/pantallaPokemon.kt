package mx.uacj.pokeapi.ui.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mx.uacj.pokeapi.modelos.pokemon

@Composable
fun PantallaPokemon(modificador: Modifier = Modifier, pokemon: pokemon) {
    Column (modifier = modificador) {
        Text("Nombre: ${pokemon.name}")
        //Text("Estadisticas: ${pokemon.stats}")
        for(tipos in pokemon.types){
            Text("tipo: ${tipos.type.name}")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Column {
            for (estadistica in pokemon.stats) {
                //Text("Estadisticas: ${estadistica}", modifier = Modifier.padding(5.dp))
                Column {
                    Text("${estadistica.stat.name}")
                    //

                    Text("Base: ${estadistica.base_stat}")

                    Text("Esfuerzo: ${estadistica.effort}")

                }
                Spacer(modifier = Modifier.height(20.dp))

            }
        }

    }

}

@Preview
@Composable
fun previewPantallaPokemon(){
    //PantallaPokemon()
}