package com.evanamargain.android.evanamemorygame.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.evanamargain.android.evanamemorygame.R
import org.jetbrains.anko.intentFor

class MenuActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_menu)
  }

  fun button3x4Clicked(view: View) {
    startActivity(intentFor<GameActivity>())
  }
}
