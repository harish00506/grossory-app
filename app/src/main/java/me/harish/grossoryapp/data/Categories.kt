package me.harish.grossoryapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.drawscope.DrawScopeMarker

data class Categories(
    @StringRes val stringResourceId : Int,
    @DrawableRes val imageResourceId : Int
)
