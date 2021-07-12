package com.example.pokedextcg.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.*
import com.example.pokedextcg.R
import com.example.pokedextcg.model.cards.CardsResult
import com.example.pokedextcg.model.cards.DataItem
import com.example.pokedextcg.view.interfaces.CardsOnClick

class RecyclerViewCardsAdapter : Adapter<RecyclerViewCardsAdapter.ViewHolder> {

    var cardsList: MutableList<DataItem>? = null
    var context: Context? = null
    var listener: CardsOnClick? = null

    constructor(cardsList: MutableList<DataItem>, context: Context?) : super() {
        this.cardsList = cardsList
        this.context = context
    }

    constructor() : super()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_cards, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        var data: DataItem? = cardsList?.get(position)
        if (data != null) {
            holder.onBind(data)
        }
        holder.itemView.setOnClickListener { v: View? ->
            if (data != null) {
                listener?.click(
                    data
                )
            }
        }

    }

    override fun getItemCount(): Int {
        return cardsList?.size!!
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView? = itemView.findViewById(R.id.imageItem)

        fun onBind(data: DataItem){

            var valorImagem: String? = data.images?.small

        }

    }

    fun atualizarLista(novaLista: MutableList<DataItem>){

        if (this.cardsList?.isEmpty() == true){
            this.cardsList = novaLista
        }else{
            this.cardsList?.addAll(novaLista)
        }
        notifyDataSetChanged()

    }

    fun clear(){
        this.cardsList?.clear()
        notifyDataSetChanged()
    }

}