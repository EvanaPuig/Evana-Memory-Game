package com.evanamargain.android.evanamemorygame.view.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.evanamargain.android.evanamemorygame.R
import com.evanamargain.android.evanamemorygame.model.GameConfig
import com.evanamargain.android.evanamemorygame.view.adapters.GameGridAdapter
import com.evanamargain.android.evanamemorygame.viewmodel.GameViewModel
import kotlinx.android.synthetic.main.activity_game.*
import org.jetbrains.anko.intentFor


class GameActivity : AppCompatActivity() {

    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var gameGridAdapter: GameGridAdapter
    private lateinit var model: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val actionBar = supportActionBar
        actionBar?.setDisplayShowHomeEnabled(false)
        actionBar?.setDisplayShowTitleEnabled(false)
        val mInflater = LayoutInflater.from(this)

        val actionBarCustomView: View = mInflater.inflate(R.layout.custom_action_bar_layout, null)


        actionBar?.customView = actionBarCustomView
        actionBar?.setDisplayShowCustomEnabled(true)


        model = ViewModelProvider(this)[GameViewModel::class.java]

        intent?.extras?.get(getString(R.string.intent_size))?.let {
            model.gameSize = it as GameConfig
        }

        gridLayoutManager = GridLayoutManager(this, model.gameSize.columns)
        game_grid_rv.layoutManager = gridLayoutManager

        model.loadCardList(true)
        model.allCards.observe(this, Observer{
            gameGridAdapter = GameGridAdapter(model.allCards.value!!, applicationContext, model)
            game_grid_rv.adapter = gameGridAdapter

            moves_tv.text = "Moves: ${model.moves}"
        })
    }

    fun goBack(view: View) {
        startActivity(intentFor<MenuActivity>())
    }
}
