package mx.uacj.hiltandretrofit.api.repositorio

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import mx.uacj.hiltandretrofit.modelos.Comentario
import mx.uacj.hiltandretrofit.modelos.Publicacion
import java.util.Collections.emptyList

class almacenPlaceholder(
    override val publicaciones: MutableState<List<Publicacion>> = mutableStateOf(emptyList<Publicacion>()),
    override val comentarios: MutableState<List<Comentario>> = mutableStateOf(emptyList<Comentario>()),
    override val publicacionSeleccionada: MutableState<Publicacion> = mutableStateOf(Publicacion(
        userId = 0,
        id = 0,
        title = "404",
        body = "no encontrado"
    ))
): interfazAlmacenPlaceholder{}

    interface interfazAlmacenPlaceholder{
    val publicaciones: MutableState<List<Publicacion>>
    val comentarios: MutableState<List<Comentario>>
    val publicacionSeleccionada: MutableState<Publicacion>
}
