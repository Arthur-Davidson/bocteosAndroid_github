package mx.uacj.pokeapi.ui.molecula

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import mx.uacj.pokeapi.modelos.pokemon

@Composable
fun PokemonLista(pokemon: pokemon, modificador: Modifier = Modifier) {
    Column (modificador) {
        Text("Nombre: ${pokemon.name}")
        Text("Altura: ${pokemon.height}")
        Text("Peso: ${pokemon.weight}")
    }

}