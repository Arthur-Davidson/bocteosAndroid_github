package mx.uacj.navigationcompose.ui.controladores.navegacion

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import mx.uacj.navigationcompose.ui.atomos.OpcionNavegacion

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal() {
    val controladorDeNavegacion = rememberNavController()
    var pantallaSeleccionada by remember { mutableStateOf(1) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Column {
                            Text("Hola mundo")
                            Text("Adiós mundo")
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text("Otra columna")
                            Text("Más texto")
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Blue,
                    titleContentColor = Color.White
                )
            )
        },
        bottomBar = {
            BottomAppBar(containerColor = Color.Blue) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 8.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    OpcionNavegacion(
                        texto = "Ir a Video",
                        seleccionado = pantallaSeleccionada == 0,
                        alPulsar = {
                            pantallaSeleccionada = 0
                            controladorDeNavegacion.navigate(VIDEO)
                        }
                    )

                    OpcionNavegacion(
                        texto = "Ir a Inicio",
                        seleccionado = pantallaSeleccionada == 1,
                        alPulsar = {
                            pantallaSeleccionada = 1
                            controladorDeNavegacion.navigate(INICIO)
                        }
                    )

                    Text(
                        "Ir a Canal",
                        color = if (pantallaSeleccionada == 2) Color.Red else Color.Green,
                        modifier = Modifier.clickable {
                            pantallaSeleccionada = 2
                            controladorDeNavegacion.navigate(CANAL)
                        }
                    )
                }
            }
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        NavegacionInicio(
            modificador = Modifier.padding(innerPadding),
            controladorDeNavegacion = controladorDeNavegacion
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PrevistaPantallaPrincipal() {
    PantallaPrincipal()
}
