package mx.uacj.pokeapi.ui.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dagger.Lazy

@Composable fun pantallaPrincipal(modificador: Modifier = Modifier) {
    Column {
        Text("Hola mundo ${controladorPokemones.pokemones.value.size}")
    }

    LazyColumn {
        for (pokemon in controladorPokemones.pokemones.value){
            Text("Pokemon: ${pokemon.name}")
        }
    }

}

@Composable
@Preview(showBackground = true)
fun previewPantallaPrincipal() {
    pantallaPrincipal()
}