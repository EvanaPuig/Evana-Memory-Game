package com.evanamargain.android.evanamemorygame.model

enum class GameConfig(val description: String, val columns: Int, val rows: Int) {
    THREE_BY_FOUR("3x4", columns = 3, rows = 4),
    FIVE_BY_TWO("5x2", columns = 5, rows = 2),
    FOUR_BY_FOUR("4x4", columns = 4, rows = 4),
    FOUR_BY_FIVE("4x5", columns = 4, rows = 5)
}