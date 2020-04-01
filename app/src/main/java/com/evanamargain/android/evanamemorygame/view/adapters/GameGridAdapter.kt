package com.evanamargain.android.evanamemorygame.view.adapters

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView
import com.evanamargain.android.evanamemorygame.R
import com.evanamargain.android.evanamemorygame.inflate
import com.evanamargain.android.evanamemorygame.model.Card
import kotlinx.android.synthetic.main.recyclerview_item_card.view.*

class GameGridAdapter(private val cards: ArrayList<Card>, private val context: Context) : RecyclerView.Adapter<GameGridAdapter.CardHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameGridAdapter.CardHolder {
        val inflatedView = parent.inflate(R.layout.recyclerview_item_card, false)
        return CardHolder(inflatedView, context)
    }

    override fun getItemCount() = cards.size

    override fun onBindViewHolder(holder: GameGridAdapter.CardHolder, position: Int) {
        val itemCard = cards[position]
        holder.bindCard(itemCard)
    }

    class CardHolder(v: View, context: Context) : RecyclerView.ViewHolder(v), View.OnClickListener {

        private var view: View = v
        private var card: Card? = null
        private var context: Context

        init {
            v.setOnClickListener(this)
            this.context = context
        }

        override fun onClick(v: View) {
            Log.d("RecyclerView", "Flip card!")
            var images = (context.resources.obtainTypedArray(R.array.card_fronts))
            var imageToSet = card?.drawableFront?.let { images.getDrawable(it) }
            view.itemImage.setImageDrawable(imageToSet)
        }

        fun bindCard(card: Card) {
            this.card = card
            var drawable = ResourcesCompat.getDrawable(context.resources, card.drawableBack, null)
            view.itemImage.setImageDrawable(drawable)
        }

        companion object {
            private val CARD_KEY = "CARD"
        }
    }

}

