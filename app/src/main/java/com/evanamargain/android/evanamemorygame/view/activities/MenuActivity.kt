package com.evanamargain.android.evanamemorygame.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.evanamargain.android.evanamemorygame.R
import com.evanamargain.android.evanamemorygame.viewmodel.MenuViewModel
import org.jetbrains.anko.intentFor

class MenuActivity : AppCompatActivity() {

    private val TAG: String? = MenuActivity::class.simpleName
    private val menuViewModel = MenuViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }

    fun buttonClicked(view: View) {
        val sizeOfGame = menuViewModel.determineGameSize(view)
        startActivity(intentFor<GameActivity>("size" to sizeOfGame))
    }
}
