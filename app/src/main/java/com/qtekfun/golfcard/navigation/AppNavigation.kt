package com.qtekfun.golfcard.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.qtekfun.golfcard.screens.GameScreen
import com.qtekfun.golfcard.screens.StartScreen

@Composable
fun AppNavgation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.StartScreen.route) {
        composable(route = AppScreens.StartScreen.route) {
            StartScreen(navController)
        }
        composable(route = AppScreens.GameScreen.route) {
            GameScreen(navController)
        }
    }
}