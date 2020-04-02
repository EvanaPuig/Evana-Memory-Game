package com.evanamargain.android.evanamemorygame.view.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.evanamargain.android.evanamemorygame.R
import com.evanamargain.android.evanamemorygame.model.Card
import com.evanamargain.android.evanamemorygame.model.GameConfig
import com.evanamargain.android.evanamemorygame.view.adapters.GameGridAdapter
import com.evanamargain.android.evanamemorygame.viewmodel.GameViewModel
import kotlinx.android.synthetic.main.activity_game.*


class GameActivity : AppCompatActivity() {

    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var gameGridAdapter: GameGridAdapter
    private lateinit var model: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        var actionBar = actionBar


        model = ViewModelProvider(this)[GameViewModel::class.java]

        intent?.extras?.get("size")?.let {
            model.gameSize = it as GameConfig
        }

        gridLayoutManager = GridLayoutManager(this, model.gameSize.columns)
        game_grid_rv.layoutManager = gridLayoutManager

        model.loadCardList(true)
        model.allCards.observe(this, Observer{
            Log.d("Log", "changed")
            gameGridAdapter = GameGridAdapter(model.allCards.value!!, applicationContext, model)
            game_grid_rv.adapter = gameGridAdapter
        })





    }




}
