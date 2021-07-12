package com.example.pokedextcg.data.remote

import com.example.pokedextcg.model.cards.CardsResult
import com.example.pokedextcg.model.cards.DataItem
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PokeTcgAPI {

    @GET("cards")
    fun getAllCards(): Observable<MutableList<DataItem>>


}