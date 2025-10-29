package mx.uacj.pokeapi.modelos

data class Maquina(
    val id: Int,
    val item: NamedAPIResource,
    val move: NamedAPIResource,
    val version_group: NamedAPIResource
)

data class NamedAPIResource(
    val name: String,
    val url: String
)

