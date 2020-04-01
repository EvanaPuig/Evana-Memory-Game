package com.evanamargain.android.evanamemorygame.model

import android.graphics.drawable.Drawable

data class Card(
    var uniqueId: Int,
    var drawableBack: Int = 0,
    var drawableFront: Int = 0,
    var matched: Boolean = false,
    var closed: Boolean = false,
    var disabled: Boolean = false,
    var opened: Boolean = false
)