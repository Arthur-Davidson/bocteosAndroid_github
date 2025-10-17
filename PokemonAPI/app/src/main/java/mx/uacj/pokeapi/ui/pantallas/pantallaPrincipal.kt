package mx.uacj.pokeapi.ui.pantallas

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable fun pantallaPrincipal(modificador: Modifier = Modifier) {
    Column {
        Text("Hola mundo")
    }

}

@Composable
@Preview(showBackground = true)
fun previewPantallaPrincipal() {
    pantallaPrincipal()
}