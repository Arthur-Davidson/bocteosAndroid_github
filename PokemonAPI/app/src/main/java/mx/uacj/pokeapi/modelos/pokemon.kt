package mx.uacj.pokeapi.modelos

// Habilidades
data class HabilidadURL(
    val name: String,
    val url: String
)

data class Habilidad(
    val is_hidden: Boolean,
    val slot: Int,
    val ability: HabilidadURL
)

// Aullido (cries)
data class Aullido(
    val latest: String?,
    val legacy: String?
)

// Sprites (imágenes)
data class Sprite(
    val back_default: String?,
    val back_female: String?,
    val back_shiny: String?,
    val back_shiny_female: String?,
    val front_default: String?,
    val front_female: String?,
    val front_shiny: String?,
    val front_shiny_female: String?
)

data class EstadisticaBase(
    val base_stat: Int,
    val effort: Int,
    val stat: Estadistica
)

data class Estadistica(
    val name: String,
    val url: String //"https://pokeapi.co/api/v2/stat/6/"
)

// Pokémon principal
data class pokemon(
    val id: Int,
    val name: String,
    val base_experience: Int,
    val height: Int,
    val is_default: Boolean,
    val order: Int,
    val weight: Int,

    val abilities: List<Habilidad>,
    val sprites: Sprite,
    val cries: Aullido,
    val stats: List<EstadisticaBase>,
)
