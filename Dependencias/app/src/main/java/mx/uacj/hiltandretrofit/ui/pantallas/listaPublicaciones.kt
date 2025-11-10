package mx.uacj.hiltandretrofit.ui.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.uacj.hiltandretrofit.controlador.ControladorPublicaciones
import mx.uacj.hiltandretrofit.modelos.Publicacion

@Composable
fun ListaPublicaciones(
    modificador: Modifier = Modifier,
    navegarAPublicacion: (Publicacion) -> Unit // acepta una publicación como argumento
) {
    val controlador = hiltViewModel<ControladorPublicaciones>()
    val publicaciones = controlador.publicaciones.value

    // Cargar publicaciones al entrar por primera vez
    LaunchedEffect(Unit) {
        controlador.obtenerPublicaciones()
    }

    Column(
        modifier = modificador
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color(0xFFFFF8EB.toLong()))
    ) {
        // Encabezado con contador de publicaciones
        Text(
            text = "Tenemos la cantidad de ${publicaciones.size} publicaciones",
            color = Color.White, // texto blanco
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color(0xFF175219.toLong())) // fondo verde oscuro
                .padding(10.dp) // espacio interno
        )
        Column(
            modifier = modificador
                .fillMaxSize()
                .padding(10.dp) // espacio interno
        ) {

            // Si aún no hay publicaciones, mostramos un indicador
            if (publicaciones.isEmpty()) {
                CircularProgressIndicator(
                    color = Color(0xFF021F0A.toLong()),
                    modifier = Modifier.padding(top = 20.dp)
                )
            } else {
                // Lista de publicaciones
                for (publicacion in publicaciones) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp)
                            .background(
                                color = Color(0xFFA8FFBF.toLong()),
                                shape = androidx.compose.foundation.shape.RoundedCornerShape(12.dp)
                            )
                            .clickable {
                                controlador.seleccionarPublicacion(publicacion.id)
                                navegarAPublicacion(publicacion) // aquí navega pasando la publicación
                            }
                            .padding(12.dp)
                    ) {
                        Text(
                            text = publicacion.title,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            color = Color(0xFF021F0A.toLong())
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = publicacion.body.take(100) + "...",
                            fontSize = 14.sp,
                            color = Color.DarkGray
                        )
                    }
                }
            }
        }
    }
}
