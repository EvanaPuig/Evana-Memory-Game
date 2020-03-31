package com.evanamargain.android.evanamemorygame.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.evanamargain.android.evanamemorygame.R
import com.evanamargain.android.evanamemorygame.model.GameConfig
import org.jetbrains.anko.intentFor

class MenuActivity : AppCompatActivity() {

  private val TAG : String? = MenuActivity::class.simpleName

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_menu)
  }

  fun buttonClicked(view: View) {
    var sizeOfGame = GameConfig.THREE_BY_FOUR
    when (view.id) {
      R.id.memory_game_menu_3x4_button -> sizeOfGame = GameConfig.THREE_BY_FOUR
      R.id.memory_game_menu_5x2_button -> sizeOfGame = GameConfig.FIVE_BY_TWO
      R.id.memory_game_menu_4x4_button -> sizeOfGame = GameConfig.FOUR_BY_FOUR
      R.id.memory_game_menu_4x5_button -> sizeOfGame = GameConfig.FOUR_BY_FIVE
    }
    startActivity(intentFor<GameActivity>("size" to sizeOfGame))
  }
}
