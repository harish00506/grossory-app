package me.harish.grossoryapp.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Item(
    @StringRes  val stringResourceId : Int,
    val itemCategoryId : Int,
    val itemQualityId : String,
    val itemPrice : Int,
    @DrawableRes val imageResourceId : Int
)
