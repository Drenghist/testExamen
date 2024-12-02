package com.example.testexamen.navigation


import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.testexamen.screens.Game
import com.example.testexamen.screens.GameOver
import com.example.testexamen.screens.Home
import com.example.testexamen.ui.GameViewModel

@Composable
fun AppNavigation(
    //Creo aquí la instancia de la gameViewModel
    gameViewModel : GameViewModel = viewModel()
) {
    val navController = rememberNavController()
    val gameUiState by gameViewModel.uiState.collectAsState()

    NavHost(navController, startDestination = AppScreens.Home.route) {
        composable(AppScreens.Home.route){
            Home(
                goGame = {
                    navController.navigate(route = AppScreens.Game.route)
                }
            )
        }
        composable(AppScreens.Game.route){
            Game(
                goResult  = {
                    navController.navigate(route = AppScreens.GameOver.route+"/$it")
                },
                player1Value = gameUiState.player1Number,
                player2Value = gameUiState.player2Number,
                player1Click = {gameViewModel.player1Click()},
                player2Click = {gameViewModel.player2Click()},
                escogeGanador = {gameViewModel.updateGanador()},
                goBack = {navController.popBackStack()}
            )
        }
        composable(AppScreens.GameOver.route+ "/{text}", arguments = listOf(navArgument(name = "text") {
            type = NavType.StringType
        }
        )) {
            GameOver(
                //winner = gameUiState.winner, AR:Ya no me hace falta, paso x parámetros
                goHome = {
                    navController.popBackStack(route = AppScreens.Home.route,false)
                },
                resetGame = {
                    gameViewModel.resetGame()
                },
                mensaje = it.arguments?.getString("text")
            )
        }
    }

}