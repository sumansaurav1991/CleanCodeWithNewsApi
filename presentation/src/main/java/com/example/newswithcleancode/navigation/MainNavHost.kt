package com.example.newswithcleancode.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.newswithcleancode.R
import com.example.newswithcleancode.components.DetailScreen
import com.example.newswithcleancode.ui.MainPage
import com.example.newswithcleancode.viewmodel.MainViewModel

@Composable
fun MainNavHost(

) {
    val navController = rememberNavController()
    val backstack = navController.currentBackStackEntryAsState()
    val mainViewModel: MainViewModel = viewModel()

    Scaffold(
        bottomBar = { MainBottomBar(currentRoute = backstack.value?.destination?.route) {
            navController.navigate(it) {
                popUpTo(NavDes.Home.route)
                launchSingleTop = true
            }
        } }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = NavDes.Home.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(NavDes.Home.route) {
                MainPage(hiltViewModel()) { mainViewModel.selectNews(it) }
            }

            composable(NavDes.Fav.route) {

            }

            composable(NavDes.Settings.route) {

            }
        }

        mainViewModel.selectedNews?.let {
            BackHandler { mainViewModel.unselectNews() }
            DetailScreen(
                data = it,
                modifier = Modifier
                    .fillMaxSize()
                    .paint(
                        painterResource(id = R.drawable.background),
                        contentScale = ContentScale.FillBounds
                    )
                    .padding(padding)
            ) { mainViewModel.unselectNews() }
        }
    }
}