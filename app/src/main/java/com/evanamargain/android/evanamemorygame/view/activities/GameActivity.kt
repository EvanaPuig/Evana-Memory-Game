package com.evanamargain.android.evanamemorygame.view.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.evanamargain.android.evanamemorygame.R
import com.evanamargain.android.evanamemorygame.model.Card
import com.evanamargain.android.evanamemorygame.model.GameConfig
import com.evanamargain.android.evanamemorygame.view.adapters.GameGridAdapter
import com.evanamargain.android.evanamemorygame.viewmodel.GameViewModel
import kotlinx.android.synthetic.main.activity_game.*


class GameActivity : AppCompatActivity() {

    private lateinit var sizeOfGame: GameConfig
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var gameGridAdapter: GameGridAdapter
    private lateinit var model: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        model = GameViewModel()

        intent?.extras?.get("size")?.let {
            sizeOfGame = it as GameConfig
        }

        gridLayoutManager = GridLayoutManager(this, sizeOfGame.columns)
        game_grid_rv.layoutManager = gridLayoutManager

        val cards = model.getCardList()
        gameGridAdapter = GameGridAdapter(cards.value!!, applicationContext)
        game_grid_rv.adapter = gameGridAdapter
    }




}
