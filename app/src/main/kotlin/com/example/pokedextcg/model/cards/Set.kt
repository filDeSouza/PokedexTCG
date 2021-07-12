package com.example.pokedextcg.model.cards

import java.io.Serializable

data class Set(
	val id: String? = null,
	val name: String? = null,
	val series: String? = null,
	val printedTotal: Int? = null,
	val total: Int? = null,
	val legalities: Legalities? = null,
	val ptcgoCode: String? = null,
	val releaseDate: String? = null,
	val updatedAt: String? = null,
	val images: Images? = null
)