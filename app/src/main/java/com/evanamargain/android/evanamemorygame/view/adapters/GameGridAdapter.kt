package com.evanamargain.android.evanamemorygame.view.adapters

import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.evanamargain.android.evanamemorygame.model.Card

class GameGridAdapter(private val cards: ArrayList<Card>) : RecyclerView.Adapter<GameGridAdapter.CardHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameGridAdapter.CardHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = cards.size

    override fun onBindViewHolder(holder: GameGridAdapter.CardHolder, position: Int) {
        TODO("Not yet implemented")
    }

    class CardHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v
        private var card: Card? = null

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            Log.d("RecyclerView", "CLICK!")
        }

        companion object {
            private val CARD_KEY = "CARD"
        }
    }

}

