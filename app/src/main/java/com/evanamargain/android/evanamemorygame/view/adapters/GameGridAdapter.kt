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
import com.evanamargain.android.evanamemorygame.viewmodel.GameViewModel
import kotlinx.android.synthetic.main.recyclerview_item_card.view.*

class GameGridAdapter(private val cards: ArrayList<Card>, private val context: Context, private val model: GameViewModel) : RecyclerView.Adapter<GameGridAdapter.CardHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardHolder {
        val inflatedView = parent.inflate(R.layout.recyclerview_item_card, false)
        return CardHolder(inflatedView, context, model)
    }

    override fun getItemCount() = cards.size

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        val itemCard = cards[position]
        holder.bindCard(itemCard)
    }

    class CardHolder(v: View, context: Context, model: GameViewModel) : RecyclerView.ViewHolder(v), View.OnClickListener {
        private var view: View = v
        private var card: Card? = null
        private var context: Context
        private var model: GameViewModel

        init {
            v.setOnClickListener(this)
            this.context = context
            this.model = model
        }

        override fun onClick(v: View) {
            Log.d("RecyclerView", "Flip card!")
            if(!card?.disabled!!) {
                val images = (context.resources.obtainTypedArray(R.array.card_fronts))
                val imageToSet = card?.drawableFront?.let { images.getDrawable(it) }
                view.itemImage.setImageDrawable(imageToSet)
                model.cardOpen(card!!)
            }
        }

        fun bindCard(card: Card) {
            this.card = card
            if (!card.matched) {
                val drawable =
                    ResourcesCompat.getDrawable(context.resources, card.drawableBack, null)
                view.itemImage.setImageDrawable(drawable)
            } else {
                val images = (context.resources.obtainTypedArray(R.array.card_fronts))
                val imageToSet = card.drawableFront.let { images.getDrawable(it) }
                images.recycle()
                view.itemImage.setImageDrawable(imageToSet)
            }
        }
    }
}

