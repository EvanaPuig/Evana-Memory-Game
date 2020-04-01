package com.evanamargain.android.evanamemorygame.viewmodel

import android.os.Handler
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.evanamargain.android.evanamemorygame.R
import com.evanamargain.android.evanamemorygame.model.Card
import com.evanamargain.android.evanamemorygame.model.GameConfig

class GameViewModel : ViewModel() {
    lateinit var allCards: MutableLiveData<ArrayList<Card>>
    private var openedCards = ArrayList<Card>()
    private var moves = 0
    var gameSize = GameConfig.THREE_BY_FOUR

    fun getCardList(): MutableLiveData<ArrayList<Card>> {
        allCards = MutableLiveData<ArrayList<Card>>()
        loadCardList(gameSize)

        return allCards
    }

    private fun loadCardList(sizeOfGame: GameConfig) {
        val allCardsData = ArrayList<Card>()

        val totalSize = sizeOfGame.columns * sizeOfGame.rows
        val randomList = (0..9).shuffled().take(totalSize/2)

        for ((cardIndex) in (0 until totalSize/2).withIndex()) {
            allCardsData.add(Card(cardIndex, R.drawable.all_card_backs, randomList[cardIndex]))
            allCardsData.add(Card(cardIndex, R.drawable.all_card_backs, randomList[cardIndex]))
        }
        allCardsData.shuffle()

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
        openedCards.clear()
        for (card in this.allCards.value!!) {
            if (!card.matched) {
                card.opened = false
            }
        }
    }

    //for when cards match
    private fun matched(card1: Card, card2: Card){
        Log.d("Log", "cards match!")
        openedCards.remove(card1)
        openedCards.remove(card2)
        card1.matched = true
        card2.matched = true
        card1.opened = true
        card2.opened = true
        openedCards.clear()
    }

    //for when cards don't match
    private fun unmatched(card1: Card, card2: Card){
        Log.d("Log", "cards dont match :(")
        card1.matched = false
        card2.matched = false
        allCards.value?.let { disable(it) }

        var myHandler = Handler()
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