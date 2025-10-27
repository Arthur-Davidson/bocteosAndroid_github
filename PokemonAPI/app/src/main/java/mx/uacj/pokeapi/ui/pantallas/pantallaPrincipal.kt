package mx.uacj.pokeapi.ui.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.uacj.pokeapi.modelos.pokemon
import mx.uacj.pokeapi.ui.molecula.PokemonLista
import mx.uacj.pokeapi.viewmodels.pokemonesViewModel

@Composable
fun pantallaPrincipal(
    modificador: Modifier = Modifier,
    controladorPokemones: pokemonesViewModel = hiltViewModel()
) {
    val controlNav = rememberNavController()
    var pokemonSeleccionado by remember { mutableStateOf<pokemon?>(null) }

    NavHost(navController = controlNav, startDestination = "listaPokemones") {
        composable("listaPokemones") {
            Column(
                modifier = modificador
                    .fillMaxSize()
                    .background(Color(0xFFFFFDE7))
            ) {
                // Encabezado
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF0D47A1))
                        .padding(16.dp)
                ) {
                    Text(
                        text = "Atrapa a los ${controladorPokemones.pokemones.value.size} pokemones",
                        color = Color(0xFFFFEB3B), // amarillo
                        fontWeight = FontWeight.Bold,
                        fontSize = 26.sp,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = androidx.compose.ui.text.style.TextAlign.Center
                    )
                }

                // Lista de pokemones
                Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
                    for (pokemon in controladorPokemones.pokemones.value) {
                        PokemonLista(
                            pokemon = pokemon,
                            modificador = Modifier.clickable {
                                pokemonSeleccionado = pokemon
                                controlNav.navigate("pantallaPokemones")
                            }
                        )
                    }
                }
            }
        }

        composable("pantallaPokemones") {
            PantallaPokemon(modificador = modificador, pokemon = pokemonSeleccionado!!)
        }
    }
}

@Composable
@Preview(showBackground = true)
fun previewPantallaPrincipal() {
    pantallaPrincipal()
}
