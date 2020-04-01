package com.evanamargain.android.evanamemorygame.view.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.evanamargain.android.evanamemorygame.R
import com.evanamargain.android.evanamemorygame.model.Card
import com.evanamargain.android.evanamemorygame.model.GameConfig
import com.evanamargain.android.evanamemorygame.view.adapters.GameGridAdapter
import kotlinx.android.synthetic.main.activity_game.*
import kotlin.math.roundToInt


class GameActivity : AppCompatActivity() {

    private lateinit var sizeOfGame: GameConfig
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var gameGridAdapter: GameGridAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        intent?.extras?.get("size")?.let {
            sizeOfGame = it as GameConfig
        }

        gridLayoutManager = GridLayoutManager(this, sizeOfGame.columns)
        game_grid_rv.layoutManager = gridLayoutManager

        val cards = loadCardList()
        gameGridAdapter = GameGridAdapter(cards, applicationContext)
        game_grid_rv.adapter = gameGridAdapter
    }

    private fun loadCardList(): ArrayList<Card> {
        val cards = ArrayList<Card>()

        var totalSize = sizeOfGame.columns * sizeOfGame.rows
        val randomList = (0..9).shuffled().take(totalSize/2)

        for ((i, card) in (0 until totalSize/2).withIndex()) {
            cards.add(Card(R.drawable.all_card_backs, randomList[i]))
            cards.add(Card(R.drawable.all_card_backs, randomList[i]))
        }

        cards.shuffle()

        return cards
    }
}
