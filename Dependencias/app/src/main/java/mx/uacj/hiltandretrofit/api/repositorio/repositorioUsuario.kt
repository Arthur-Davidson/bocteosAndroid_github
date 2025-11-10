package mx.uacj.hiltandretrofit.api.repositorio

import mx.uacj.hiltandretrofit.api.JSONPlaceholder
import mx.uacj.hiltandretrofit.modelos.Usuario
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositorioUsuarios @Inject constructor(
    private val api: JSONPlaceholder
) {
    suspend fun obtenerUsuarios(): List<Usuario> {
        return api.obtenerUsuarios()
    }

    suspend fun obtenerUsuarioPorId(id: Int): Usuario {
        return api.obtenerUsuarioPorId(id)
    }
}
