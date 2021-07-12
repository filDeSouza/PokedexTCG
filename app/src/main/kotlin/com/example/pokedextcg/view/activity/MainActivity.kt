package com.example.pokedextcg.view.activity

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedextcg.R
import com.example.pokedextcg.model.cards.DataItem
import com.example.pokedextcg.view.adapter.RecyclerViewCardsAdapter
import com.example.pokedextcg.view.viewmodel.CardsViewModel

class MainActivity : AppCompatActivity() {

    val recyclerView: RecyclerView? = null
    var progressBar: ProgressBar = TODO()
    var adapter: RecyclerViewCardsAdapter = TODO()
    var listaCards: List<DataItem>
    var viewModel: CardsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (recyclerView != null) {
            recyclerView.setAdapter(adapter)
        }
        recyclerView!!.setLayoutManager(GridLayoutManager(this, 2))
        setScrollView()

        viewModel.getAllCards()

        viewModel.getListaCards()?.observe(this, resultadolista -> {
            adapter.atualizarLista(resultadoLista)
        })

        viewModel.getLoading().observe(this, loading -> {
            if (loading)
                progressBar.visibility(View.VISIBLE)
        })

    }

    private fun setScrollView() {
        TODO("Not yet implemented")
    }
}