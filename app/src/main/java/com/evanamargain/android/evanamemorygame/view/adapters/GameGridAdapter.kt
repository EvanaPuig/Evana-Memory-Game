package com.evanamargain.android.evanamemorygame.view.adapters

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.evanamargain.android.evanamemorygame.R
import com.evanamargain.android.evanamemorygame.inflate
import com.evanamargain.android.evanamemorygame.model.Card
import kotlinx.android.synthetic.main.recyclerview_item_card.view.*
import org.jetbrains.anko.image

class GameGridAdapter(private val cards: ArrayList<Card>) : RecyclerView.Adapter<GameGridAdapter.CardHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameGridAdapter.CardHolder {
        val inflatedView = parent.inflate(R.layout.recyclerview_item_card, false)
        return CardHolder(inflatedView)
    }

    override fun getItemCount() = cards.size

    override fun onBindViewHolder(holder: GameGridAdapter.CardHolder, position: Int) {
        val itemCard = cards[position]
        holder.bindCard(itemCard)
    }

    class CardHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v
        private var card: Card? = null

        init {
            v.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            Log.d("RecyclerView", "Flip card!")
        }

        fun bindCard(card: Card) {
            this.card = card
        }

        companion object {
            private val CARD_KEY = "CARD"
        }
    }

}
