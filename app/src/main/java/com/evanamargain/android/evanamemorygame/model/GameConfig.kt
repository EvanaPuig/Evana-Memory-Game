package com.evanamargain.android.evanamemorygame.model

enum class GameConfig(val columns: Int, val rows: Int) {
    THREE_BY_FOUR(columns = 3, rows = 4),
    FIVE_BY_TWO(columns = 5, rows = 2),
    FOUR_BY_FOUR(columns = 4, rows = 4),
    FOUR_BY_FIVE(columns = 4, rows = 5)
}