package com.example.testexamen.ui

import androidx.lifecycle.ViewModel
import com.example.testexamen.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState>  = _uiState.asStateFlow()

    fun player1Click(){
        _uiState.update { currentState ->
            currentState.copy(player1Number = (0..13).random())
        }
    }

    fun player2Click(){
        _uiState.update { currentState ->
            currentState.copy(player2Number = (0..13).random())
        }
    }

    fun updateGanador (){
        _uiState.update { currentState ->
            currentState.copy(winner = ganador())
        }
    }

    fun ganador(): Int{
        return when {
             _uiState.value.player1Number > _uiState.value.player2Number -> return (R.string.win_p1)
            _uiState.value.player1Number < _uiState.value.player2Number -> return (R.string.win_p2)
            else -> return (R.string.draw)
        }

    }

    fun resetGame(){
        _uiState.value = GameUiState()
    }

    init {
        resetGame()
    }
}