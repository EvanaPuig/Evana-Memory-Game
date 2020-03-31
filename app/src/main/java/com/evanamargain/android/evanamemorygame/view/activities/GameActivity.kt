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

        //TODO: remove this later
        game_title_tv.text =
            "Grid of size ${sizeOfGame.description} with: \n${sizeOfGame.columns} columns and ${sizeOfGame.rows} rows"

        gridLayoutManager = GridLayoutManager(this, sizeOfGame.columns)
        game_grid_rv.layoutManager = gridLayoutManager

        val cards = ArrayList<Card>()
        cards.add(Card("",R.drawable.ic_launcher_background))
        gameGridAdapter = GameGridAdapter(cards)
        game_grid_rv.adapter = gameGridAdapter
    }
}
