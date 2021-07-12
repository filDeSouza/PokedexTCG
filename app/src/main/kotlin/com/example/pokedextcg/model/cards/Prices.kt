package com.example.pokedextcg.model.cards

import java.io.Serializable

data class Prices(
	val holofoil: Holofoil? = null,
	val reverseHolofoil: ReverseHolofoil? = null
)