package com.example.pokedextcg.model.cards

import java.io.Serializable

data class DataItem(
	val id: String? = null,
	val name: String? = null,
	val supertype: String? = null,
	val subtypes: List<String?>? = null,
	val level: String? = null,
	val hp: String? = null,
	val types: List<String?>? = null,
	val evolvesFrom: String? = null,
	val abilities: List<AbilitiesItem?>? = null,
	val attacks: List<AttacksItem?>? = null,
	val weaknesses: List<WeaknessesItem?>? = null,
	val resistances: List<ResistancesItem?>? = null,
	val retreatCost: List<String?>? = null,
	val convertedRetreatCost: Int? = null,
	val set: Set? = null,
	val number: String? = null,
	val artist: String? = null,
	val rarity: String? = null,
	val nationalPokedexNumbers: List<Int?>? = null,
	val legalities: Legalities? = null,
	val images: Images? = null,
	val tcgplayer: Tcgplayer? = null
)