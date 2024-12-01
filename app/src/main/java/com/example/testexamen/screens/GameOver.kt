package com.example.testexamen.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.testexamen.R
import com.example.testexamen.navigation.AppScreens
import com.example.testexamen.ui.theme.TestExamenTheme

@Composable
fun GameOver (
    goHome: () -> Unit,
    winner : Int,
    resetGame : () -> Unit,
    ) {
    Scaffold () {
        GameOverContent(
            // it es el padding que nos llega del Scaffold
            modifier = Modifier.padding(it),
            winner = winner,
            goHome = goHome,
            resetGame = resetGame,
        )
    }



}

@Composable
fun GameOverContent (winner : Int,goHome:()-> Unit,resetGame: () -> Unit,modifier : Modifier) {
    Column (
        modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(winner),
            style = MaterialTheme.typography.titleLarge,
            color= MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(64.dp))


        Button(
            onClick = {
                goHome()
                resetGame()

            }
        ){
            Icon(
                imageVector = Icons.Filled.Refresh,
                contentDescription = ""
            )
            Text(stringResource(R.string.reiniciar))
        }

    }

}

@Preview(showBackground = true)
@Composable
fun OverPreview() {
    val navController = rememberNavController()
    TestExamenTheme {
        GameOver({ navController.navigate(route = AppScreens.GameOver.route)},0, {})
    }
}
