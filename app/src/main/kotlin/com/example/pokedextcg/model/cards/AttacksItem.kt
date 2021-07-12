package com.example.pokedextcg.model.cards

import java.io.Serializable

data class AttacksItem(
	val name: String? = null,
	val cost: List<String?>? = null,
	val convertedEnergyCost: Int? = null,
	val damage: String? = null,
	val text: String? = null
)