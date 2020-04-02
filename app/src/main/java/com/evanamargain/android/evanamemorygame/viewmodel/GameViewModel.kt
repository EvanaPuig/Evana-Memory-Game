package com.evanamargain.android.evanamemorygame.viewmodel

import android.os.Handler
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.evanamargain.android.evanamemorygame.R
import com.evanamargain.android.evanamemorygame.model.Card
import com.evanamargain.android.evanamemorygame.model.GameConfig

class GameViewModel : ViewModel() {
    var allCards = MutableLiveData<ArrayList<Card>>()
    private var openedCards = ArrayList<Card>()
    private var moves = 0
    var gameSize = GameConfig.THREE_BY_FOUR
    private val allCardsData = ArrayList<Card>()

    fun loadCardList(firstLoad: Boolean) {
        if( firstLoad ) {
            val totalSize = gameSize.columns * gameSize.rows
            val randomList = (0..9).shuffled().take(totalSize/2)

            for ((cardIndex) in (0 until totalSize/2).withIndex()) {
                allCardsData.add(Card(cardIndex, R.drawable.all_card_backs, randomList[cardIndex]))
                allCardsData.add(Card(cardIndex, R.drawable.all_card_backs, randomList[cardIndex]))
            }
            allCardsData.shuffle()
        }

        Log.d("allCards", allCardsData.toString())
        allCards.value = allCardsData
    }

    fun cardOpen(card: Card) {
        openedCards.add(card)
        Log.d("Log","openedCards $openedCards")

        if(openedCards.size == 2){
            allCards.value?.let { disable(it) }
            moveCounter()
            if(openedCards[0].uniqueId === openedCards[1].uniqueId){
                matched(openedCards[0], openedCards[1])
            } else {
                unmatched(openedCards[0], openedCards[1])
            }
        } else {
            card.disabled = true
            card.opened = true
        }
    }

    private fun cardClose() {
        for (card in this.allCards.value!!) {
            if (!card.matched) {
                card.opened = false
                card.disabled = false
            }
        }
        openedCards.clear()
        loadCardList(false)

    }

    //for when cards match
    private fun matched(card1: Card, card2: Card){
        openedCards.remove(card1)
        openedCards.remove(card2)
        card1.matched = true
        card2.matched = true
        card1.opened = true
        card2.opened = true
        cardClose()
    }

    //for when cards don't match
    private fun unmatched(card1: Card, card2: Card){
        card1.matched = false
        card2.matched = false
        allCards.value?.let { disable(it) }

        val myHandler = Handler()
        myHandler.postDelayed( {
            allCards.value?.let { enable(it) }
            cardClose()
        }, 1000)
    }

    //disable cards temporarily
    private fun disable(cards: ArrayList<Card>){
        for (card in cards) {
            card.disabled = true
        }
    }

    //enable cards and disable matched cards
    private fun enable(cards: ArrayList<Card>){
        for (card in cards) {
            if (!card.matched) {
                card.disabled = false
            }
        }
    }

    private fun moveCounter(): Int {
        return moves++
    }
}