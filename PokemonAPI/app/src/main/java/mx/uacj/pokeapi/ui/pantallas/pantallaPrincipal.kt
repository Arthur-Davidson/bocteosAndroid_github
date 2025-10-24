package mx.uacj.pokeapi.ui.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import dagger.Lazy
import mx.uacj.pokeapi.viewmodels.pokemonesViewModel

@Composable fun pantallaPrincipal(modificador: Modifier = Modifier,
                                  controladorPokemones: pokemonesViewModel = hiltViewModel())
{
    Column {
        Text("Hola mundo ${controladorPokemones.pokemones.value.size}")
    }

    LazyColumn(modifier = Modifier.verticalScroll(rememberScrollState())) {
        for(pokemon in controladorPokemones.pokemones.value){
            Text("Pokemon : ${pokemon.name}")
        }
    }
}

@Composable
@Preview(showBackground = true)
fun previewPantallaPrincipal() {
    pantallaPrincipal()
}