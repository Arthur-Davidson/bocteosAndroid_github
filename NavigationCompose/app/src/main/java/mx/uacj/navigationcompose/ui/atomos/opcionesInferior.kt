package mx.uacj.navigationcompose.ui.atomos

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun OpcionNavegacion(
    modificador: Modifier = Modifier,
    texto: String,
    seleccionado: Boolean? = null,
    colorActivo: Color = Color.Green,
    colorInactivo: Color = Color.Gray,
    alPulsar: () -> Unit = {}
) {
    val color = if (seleccionado == true) colorActivo else colorInactivo
    Text(
        text = texto,
        color = color,
        modifier = modificador.clickable { alPulsar() }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewOpcionNavegacion() {
    OpcionNavegacion(texto = "Hola mundo", seleccionado = true)
}
