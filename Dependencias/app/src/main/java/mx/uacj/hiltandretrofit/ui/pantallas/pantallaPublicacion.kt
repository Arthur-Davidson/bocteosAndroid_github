package mx.uacj.hiltandretrofit.ui.pantallas

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import mx.uacj.hiltandretrofit.controlador.ControladorPublicaciones

@Composable
fun PantallaPublicacion(
    modificador: Modifier = Modifier,
    controladorPublicaciones: ControladorPublicaciones = hiltViewModel()
) {
    val publicacion = controladorPublicaciones.publicacionSeleccionada.value
    val comentarios by controladorPublicaciones.comentarios

    Log.v("PantallaPublicacion", "Valor del controlador: $controladorPublicaciones")

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color(0xFFFFF8EB.toLong())) // fondo color piel
    ){
        Column(
            modifier = modificador
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // --- Título ---
            Text(
                text = publicacion.title,
                fontSize = 22.sp,
                color = Color(0xFF021F0A.toLong()),
                fontWeight = FontWeight.Bold
            )

            // --- Cuerpo ---
            Text(
                text = publicacion.body,
                fontSize = 16.sp,
                modifier = Modifier.padding(top = 8.dp, bottom = 16.dp,),

                )

            // --- Comentarios ---
            Text(
                text = "Comentarios:",
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = Color(0xFF021F0A.toLong())
            )

            Spacer(modifier = Modifier.height(8.dp))

            for (comentario in comentarios) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                        .background(
                            color = Color(0xFFA8FFBF.toLong()),
                            shape = RoundedCornerShape(10.dp)
                        )
                        .padding(12.dp) // padding interno de cada comentario
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
}
