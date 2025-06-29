package me.harish.grossoryapp.data

import androidx.annotation.StringRes
import me.harish.grossoryapp.R
import me.harish.grossoryapp.ui.CategoryCard

object DataSource {
    fun loadCategories(): List<Categories>{
        return listOf<Categories>(
            Categories(stringResourceId = R.string.fresh_fruits, imageResourceId = R.drawable.fruits),
            Categories(R.string.bath_body,R.drawable.bathbody),
            Categories(R.string.bread_biscuits,R.drawable.bread),
            Categories(R.string.kitchen_essentials,R.drawable.kitchen),
            Categories(R.string.munchies,R.drawable.munchies),
            Categories(R.string.packaged_food,R.drawable.packaged),
            Categories(R.string.sweet_tooth,R.drawable.sweet),
            Categories(R.string.vegetables,R.drawable.vegetables),
            Categories(R.string.beverages,R.drawable.beverages)
        )
    }
    fun loadItems(
        @StringRes categoryName :Int
    ) : List<Item>{
        return listOf(
            Item(R.string.banana,R.string.fresh_fruits,"1kg",100,R.drawable.banana_fruit),
            Item(R.string.apple_fruit,R.string.fresh_fruits,"1kg",300,R.drawable.apple_fruit),
            Item(R.string.orange_fruit,R.string.fresh_fruits,"1kg",150,R.drawable.orange_fruit),
            Item(R.string.grapes_fruit,R.string.fresh_fruits,"1kg",60,R.drawable.grapes_fruit)
        ).filter {
            it.itemCategoryId == categoryName
        }
    }
}