package com.example.newswithcleancode.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

@Composable
fun MainBottomBar(
    currentRoute: String?,
    onNavigate: (String) -> Unit
) {
    NavigationBar {
        navBarItems.forEach{
            NavigationBarItem(
                selected = currentRoute?.contains(it.route) ?: false,
                onClick = { onNavigate(it.route) },
                icon = { it.iconRes?.run{ Icon(painterResource(this), null) } },
                label = { Text(it.name ?: it.route) }
            )
        }
    }
}

private val navBarItems = listOf(
    NavDes.Home,
    NavDes.Fav,
    NavDes.Settings
)