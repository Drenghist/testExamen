package com.example.testexamen.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
            BackHandler(true) {
            }
            Home(
                goGame = {
                    navController.navigate(route = AppScreens.Game.route)
                }
            )
        }
        composable(AppScreens.Game.route){
            Game(
                goResult = {
                    navController.navigate(route = AppScreens.GameOver.route)
                },
                player1Value = gameUiState.player1Number,
                player2Value = gameUiState.player2Number,
                player1Click = {gameViewModel.player1Click()},
                player2Click = {gameViewModel.player2Click()},
                escogeGanador = {gameViewModel.updateGanador()},
                goBack = {navController.popBackStack()}
            )
        }
        composable(AppScreens.GameOver.route){
            GameOver(
                winner = gameUiState.winner,
                goHome = {
                    navController.navigate(route = AppScreens.Home.route)
                },
                resetGame = {
                    gameViewModel.resetGame()
                }
            )
        }
    }

}