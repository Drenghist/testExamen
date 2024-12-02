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
import com.example.testexamen.R
import com.example.testexamen.ui.theme.TestExamenTheme

@Composable
fun GameOver (
    goHome: () -> Unit,
    //winner : Int, AR:Ya no me hace falta, paso x parámetros
    resetGame : () -> Unit,
    mensaje:String?,
    ) {
    Scaffold () {
        GameOverContent(
            // it es el padding que nos llega del Scaffold
            modifier = Modifier.padding(it),
            //winner = winner, AR:Ya no me hace falta, paso x parámetros
            goHome = goHome,
            resetGame = resetGame,
            mensaje = mensaje,
        )
    }



}

@Composable
fun GameOverContent (goHome:()-> Unit,resetGame: () -> Unit,modifier : Modifier, mensaje : String?) {
    Column (
        modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        mensaje?.let {
            Text(
                text = stringResource(it.toInt()),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }



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
    TestExamenTheme {
        GameOver(goHome = {}, resetGame = {},mensaje  = "2131296334")
    }
}
