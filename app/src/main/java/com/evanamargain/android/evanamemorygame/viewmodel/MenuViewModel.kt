package com.evanamargain.android.evanamemorygame.viewmodel

import android.view.View
import com.evanamargain.android.evanamemorygame.R
import com.evanamargain.android.evanamemorygame.model.GameConfig

class MenuViewModel {
    fun determineGameSize(view: View): GameConfig {
        var sizeOfGame = GameConfig.THREE_BY_FOUR
        when (view.id) {
            R.id.memory_game_menu_3x4_button -> sizeOfGame = GameConfig.THREE_BY_FOUR
            R.id.memory_game_menu_5x2_button -> sizeOfGame = GameConfig.FIVE_BY_TWO
            R.id.memory_game_menu_4x4_button -> sizeOfGame = GameConfig.FOUR_BY_FOUR
            R.id.memory_game_menu_4x5_button -> sizeOfGame = GameConfig.FOUR_BY_FIVE
        }
        return sizeOfGame
    }
}