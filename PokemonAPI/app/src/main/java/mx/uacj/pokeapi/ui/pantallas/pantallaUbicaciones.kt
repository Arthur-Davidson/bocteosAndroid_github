package mx.uacj.pokeapi.ui.pantallas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import mx.uacj.pokeapi.viewmodels.UbicacionesViewModel

@Composable
fun pantallaUbicaciones(
    viewModel: UbicacionesViewModel = hiltViewModel()
) {
    val lista by viewModel.ubicaciones

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE8F5E9))
    ) {
        // Encabezado
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF0D47A1))
                .padding(16.dp)
        ) {
            Text(
                text = "Ubicaciones Pokemon",
                color = Color(0xFFFFEB3B), // amarishoo
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = androidx.compose.ui.text.style.TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)) {
            items(lista) { ubicacion ->

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = Color(0xFF9FC99F), // verdesin shida
                            shape = RoundedCornerShape(24.dp)
                        )
                        .padding(16.dp),
                ) {
                    Column {
                        Text("ID: ${ubicacion.id}",
                            color = Color(0xFFFFEB3B), // amarisho
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Bold)
                        Text("Nombre: ${ubicacion.name}",
                            color = Color.White,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold)
                        Text("Región: ${ubicacion.region.name}",
                            color = Color.White,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold)
                        Text("Area: ${ubicacion.areas.size}",
                            color = Color.White,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun previewPantallaUbicaciones() {
    pantallaUbicaciones()
}