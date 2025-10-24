package mx.uacj.pokeapi.modelos

data class Tipo(
    val name: String,
    val url: String
)

data class Tipos(
    val slot: Int,
    val type: Tipo,
)