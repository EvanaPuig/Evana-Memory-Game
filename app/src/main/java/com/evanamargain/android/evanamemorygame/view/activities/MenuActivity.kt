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

  fun buttonClicked(view: View) {
    var id = view.id
    print("button id = $id")
    startActivity(intentFor<GameActivity>())
  }
}
