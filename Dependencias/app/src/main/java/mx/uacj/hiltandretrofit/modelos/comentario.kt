package mx.uacj.hiltandretrofit.modelos

data class Comentario (
    val postId: Int,
    val id: Int,
    val name: String,
    val email: String,
    val body: String
)