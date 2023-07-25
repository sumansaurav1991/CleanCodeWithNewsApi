package com.example.newswithcleancode.navigation

import androidx.annotation.DrawableRes
import com.example.newswithcleancode.R

sealed class NavDes(
    val route: String,
    val name: String? = null,
    @DrawableRes val iconRes: Int? = null
) {
    object Home: NavDes("home", "Home", R.drawable.baseline_home_24)
    object Fav: NavDes("fav", "Favorites", R.drawable.baseline_favorite_24)
    object Settings: NavDes("settings", "Settings", R.drawable.baseline_settings_24)
}
