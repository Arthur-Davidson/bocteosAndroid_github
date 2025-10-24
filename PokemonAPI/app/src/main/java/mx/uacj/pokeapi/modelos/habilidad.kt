package mx.uacj.pokeapi.modelos

data class Habilidad(
    val is_hidden: Boolean,
    val slot: Int,
    val ability: HabilidadURL
)