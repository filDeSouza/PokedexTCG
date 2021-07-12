package com.example.pokedextcg.model.cards

import java.io.Serializable

data class CardsResult(
	val data: List<DataItem?>? = null,
	val page: Int? = null,
	val pageSize: Int? = null,
	val count: Int? = null,
	val totalCount: Int? = null
)