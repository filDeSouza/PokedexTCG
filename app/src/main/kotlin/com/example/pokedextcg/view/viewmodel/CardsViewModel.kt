package com.example.pokedextcg.view.viewmodel

import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pokedextcg.R
import com.example.pokedextcg.model.cards.CardsResult
import com.example.pokedextcg.model.cards.DataItem
import com.example.pokedextcg.repository.CardsRepository
import com.example.pokedextcg.view.adapter.RecyclerViewCardsAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CardsViewModel : AndroidViewModel {

    val listaCards: MutableLiveData<List<DataItem>>? = null
    val listaResult: MutableLiveData<CardsResult>? = null
    var loading: MutableLiveData<Int> = MutableLiveData()
    val disposable: CompositeDisposable? = null
    val repository: CardsRepository? = null
    val postListAdapter: RecyclerViewCardsAdapter = RecyclerViewCardsAdapter()


    constructor(application: Application) : super(application)

    fun getListaCards(): LiveData<List<DataItem>>? {
        return listaCards
    }

    fun getLoading(): LiveData<Int>{
        return loading
    }

    fun getAllCards(){
        repository?.getCards()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.doOnSubscribe { onRetrievePostListStart() }
            ?.doOnTerminate { onRetrievePostListFinish() }
            ?.subscribe(
                { response -> onRetrievePostListSuccess(response) },
                { onRetrievePostListError() }

            )
    }


    private fun onRetrievePostListStart(){
        loading.value = View.VISIBLE
    }

    private fun onRetrievePostListFinish(){
        loading.value = View.GONE
    }

    private fun onRetrievePostListSuccess(response: MutableList<DataItem>) {
        postListAdapter.atualizarLista(response)
    }

    private fun onRetrievePostListError(){
        Log.i("Erro: ",  "erro")
    }
}



