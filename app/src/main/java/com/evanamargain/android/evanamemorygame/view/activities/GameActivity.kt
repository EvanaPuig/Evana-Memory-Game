package com.evanamargain.android.evanamemorygame.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.drawable.toDrawable
import androidx.recyclerview.widget.GridLayoutManager
import com.evanamargain.android.evanamemorygame.R
import com.evanamargain.android.evanamemorygame.model.Card
import com.evanamargain.android.evanamemorygame.model.GameConfig
import com.evanamargain.android.evanamemorygame.view.adapters.GameGridAdapter
import kotlinx.android.synthetic.main.activity_game.*

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

        for (card in 0 until totalSize) {
            cards.add(Card("a", R.drawable.all_card_backs))
        }
        return cards
    }
}
