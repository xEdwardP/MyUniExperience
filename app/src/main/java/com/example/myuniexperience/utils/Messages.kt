package com.example.myuniexperience.utils

import android.app.Activity
import android.graphics.Color
import android.view.View
import com.google.android.material.color.MaterialColors
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

fun Activity.showErrorSnackbar(message: String) {
    val rootView = findViewById<View>(android.R.id.content)
    Snackbar.make(rootView, message, Snackbar.LENGTH_SHORT).apply {
        setBackgroundTint(MaterialColors.getColor(rootView, com.google.android.material.R.attr.colorError))
        setTextColor(Color.WHITE)
        animationMode = BaseTransientBottomBar.ANIMATION_MODE_FADE
        show()
    }
}
