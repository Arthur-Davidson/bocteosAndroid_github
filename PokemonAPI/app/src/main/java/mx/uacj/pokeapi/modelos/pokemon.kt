package mx.uacj.pokeapi.modelos

import java.sql.Types

// Pokémon principal
data class pokemon(
    val id: Int,
    val name: String,
    val types: List<Tipos>,
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
