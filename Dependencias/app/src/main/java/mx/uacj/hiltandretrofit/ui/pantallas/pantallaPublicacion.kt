package mx.uacj.hiltandretrofit.ui.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.uacj.hiltandretrofit.controlador.ControladorPublicaciones

@Composable
fun PantallaPublicacion(
    modificador: Modifier = Modifier,
    userId: Int,
    navegarAPerfil: (Int) -> Unit,
    controladorPublicaciones: ControladorPublicaciones = hiltViewModel()
) {
    val publicacion = controladorPublicaciones.publicacionSeleccionada.value
    val comentarios by controladorPublicaciones.comentarios

    Column(
        modifier = modificador
            .fillMaxSize()
            .background(Color(0xFFFFF8EB))
            .padding(16.dp)
    ) {
        // Título
        Text(
            text = publicacion.title,
            fontSize = 22.sp,
            color = Color(0xFF021F0A),
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Cuerpo
        Text(
            text = publicacion.body,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Botón Ver perfil
        Text(
            text = "👤 Ver perfil del autor",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .clickable { navegarAPerfil(userId) }
                .background(Color(0xFF175219), RoundedCornerShape(8.dp))
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Comentarios
        Text(
            text = "Comentarios:",
            fontWeight = FontWeight.SemiBold,
            fontSize = 18.sp,
            color = Color(0xFF021F0A)
        )

        Spacer(modifier = Modifier.height(8.dp))

        for (comentario in comentarios) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp)
                    .background(Color(0xFFA8FFBF), RoundedCornerShape(10.dp))
                    .padding(12.dp)
            ) {
                Text(
                    text = comentario.body,
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
            }
        }
    }
}
