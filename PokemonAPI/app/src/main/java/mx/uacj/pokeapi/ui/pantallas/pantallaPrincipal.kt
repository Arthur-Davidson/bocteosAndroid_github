package mx.uacj.pokeapi.ui.pantallas

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.Lazy
import mx.uacj.pokeapi.modelos.pokemon
import mx.uacj.pokeapi.ui.molecula.PokemonLista
import mx.uacj.pokeapi.viewmodels.pokemonesViewModel

@Composable fun pantallaPrincipal(modificador: Modifier = Modifier,
                                  controladorPokemones: pokemonesViewModel = hiltViewModel()) {

    val controlNav = rememberNavController()

    var pokemonSeleccionado by remember { mutableStateOf<pokemon?>(null) }

    NavHost(navController = controlNav, startDestination = "listaPokemones"){
        composable("listaPokemones") {
            Column (modifier = modificador) {
                Column {
                    Text("Atrapa a los ${controladorPokemones.pokemones.value.size} pokemones")
                }

                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    for(pokemon in controladorPokemones.pokemones.value){
                        PokemonLista(pokemon = pokemon, modificador = Modifier.clickable {
                            pokemonSeleccionado = pokemon
                            controlNav.navigate("pantallaPokemones")
                        })
                    }
                }
            }
        }

        composable ("pantallaPokemones") {
            PantallaPokemon(modificador = modificador, pokemon = pokemonSeleccionado!!)
        }
    }

}

@Composable
@Preview(showBackground = true)
fun previewPantallaPrincipal() {
    pantallaPrincipal()
}