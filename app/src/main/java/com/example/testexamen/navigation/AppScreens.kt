package com.example.testexamen.navigation

sealed class AppScreens(val route: String) {
    object Home : AppScreens("home")
    object Game : AppScreens("game")
    object GameOver : AppScreens("game_over")
}
