package com.qtekfun.golfcard.navigation

sealed class AppScreens(val route: String) {
    object StartScreen : AppScreens("start_screen")
    object GameScreen : AppScreens("game_screen")
}