package mx.uacj.pokeapi.modelos

// -------------------
// Habilidades
// -------------------
data class HabilidadURL(
    val name: String,
    val url: String
)

data class Habilidad(
    val is_hidden: Boolean,
    val slot: Int,
    val ability: HabilidadURL
)

// -------------------
// Aullido (cries)
// -------------------
data class Aullido(
    val latest: String?,
    val legacy: String?
)

// -------------------
// Sprites (imágenes)
// -------------------
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

// -------------------
// Stats (atributos base como speed, attack...)
// -------------------
data class StatURL(
    val name: String,
    val url: String
)

data class Stat(
    val base_stat: Int,
    val effort: Int,
    val stat: StatURL
)

// -------------------
// Tipos (fairy, fire, water...)
// -------------------
data class TipoURL(
    val name: String,
    val url: String
)

data class Tipo(
    val slot: Int,
    val type: TipoURL
)

// -------------------
// Generaciones pasadas (past_types, past_abilities)
// -------------------
data class GenerationURL(
    val name: String,
    val url: String
)

data class PastType(
    val slot: Int,
    val type: TipoURL
)

data class PastTypeEntry(
    val generation: GenerationURL,
    val types: List<PastType>
)

data class PastAbility(
    val ability: HabilidadURL?,
    val is_hidden: Boolean,
    val slot: Int
)

data class PastAbilityEntry(
    val generation: GenerationURL,
    val abilities: List<PastAbility>
)

// -------------------
// Pokémon principal
// -------------------
data class Pokemon(
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
    val stats: List<Stat>,
    val types: List<Tipo>,
    val past_types: List<PastTypeEntry>,
    val past_abilities: List<PastAbilityEntry>
)
