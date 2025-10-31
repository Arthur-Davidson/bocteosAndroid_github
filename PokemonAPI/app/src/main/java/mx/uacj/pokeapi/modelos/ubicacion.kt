package mx.uacj.pokeapi.modelos

data class Ubicacion(
    val id: Int,
    val name: String,
    val region: Region,
    val areas: List<Area>,
    val game_indices: List<GameIndex>
)

data class Region(
    val name: String,
    val url: String
)

data class Area(
    val name: String,
    val url: String
)

data class GameIndex(
    val game_index: Int,
    val generation: Generation
)

data class Generation(
    val name: String,
    val url: String
)
