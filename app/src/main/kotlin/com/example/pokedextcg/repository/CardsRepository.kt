package com.example.pokedextcg.repository

import retrofit2.Call
import java.util.*
import io.reactivex.Observable
import com.example.pokedextcg.data.remote.RetrofitService.getApiService
import com.example.pokedextcg.model.cards.CardsResult
import com.example.pokedextcg.model.cards.DataItem


abstract class CardsRepository {

    fun getCards(): Observable<MutableList<DataItem>>{
        return getApiService().getAllCards()
    }

}