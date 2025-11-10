package mx.uacj.hiltandretrofit.ui.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.uacj.hiltandretrofit.controlador.ControladorUsuarios

@Composable
fun PantallaPerfil(
    userId: Int,
    modificador: Modifier = Modifier,
    controladorUsuarios: ControladorUsuarios = hiltViewModel()
) {
    // Cargar solo el usuario solicitado
    LaunchedEffect(userId) {
        controladorUsuarios.obtenerUsuarioPorId(userId)
    }

    val usuario = controladorUsuarios.usuarioSeleccionado.value

    Column(
        modifier = modificador
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFFFF8EB))
            .padding(16.dp)
    ) {
        if (usuario != null) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Perfil de ${usuario.name}",
                fontWeight = FontWeight.Bold,
                color = Color.White,
                fontSize = 22.sp,
                modifier = Modifier
                    .background(Color(0xFF175219), RoundedCornerShape(8.dp))
                    .padding(12.dp)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier
                    .background(Color(0xFFA8FFBF), RoundedCornerShape(12.dp))
                    .padding(12.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Nombre: ${usuario.name}", fontSize = 25.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Usuario: ${usuario.username}", fontSize = 20.sp)
                Text(text = "Correo: ${usuario.email}", fontSize = 20.sp)
                Text(text = "Teléfono: ${usuario.phone}", fontSize = 20.sp)
                Text(text = "Sitio web: ${usuario.website}", fontSize = 20.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Dirección:", fontWeight = FontWeight.Bold)
                Text(text = "${usuario.address.street}, ${usuario.address.city}")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Compañía:", fontWeight = FontWeight.Bold)
                Text(text = usuario.company.name)
                Text(text = "\"${usuario.company.catchPhrase}\"", fontStyle = FontStyle.Italic)
            }
        } else {
            Text(
                text = "Cargando perfil...",
                color = Color.Gray,
                fontSize = 20.sp,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
