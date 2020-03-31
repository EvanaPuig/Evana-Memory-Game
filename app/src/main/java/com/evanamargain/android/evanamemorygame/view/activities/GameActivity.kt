package com.evanamargain.android.evanamemorygame.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.evanamargain.android.evanamemorygame.R
import com.evanamargain.android.evanamemorygame.model.GameConfig
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    private lateinit var sizeOfGame: GameConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        intent?.extras?.get("size")?.let {
            sizeOfGame = it as GameConfig
        }
        game_tv.text =
            "Grid of size ${sizeOfGame.description} with: \n${sizeOfGame.columns} columns and ${sizeOfGame.rows} rows"
    }
}
