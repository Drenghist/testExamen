package com.example.testexamen.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.testexamen.R
import com.example.testexamen.navigation.AppScreens
import com.example.testexamen.ui.theme.TestExamenTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Game (
    goResult: () -> Unit,
    player1Value: Int,
    player2Value: Int,
    player1Click: () -> Unit,
    player2Click: () -> Unit,
    escogeGanador: () -> Unit,
){
    Scaffold (
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            //Botón de ir para atrás
                            onClick = {},
                        ){
                            Icon (
                                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "",
                                )
                        }
                        Spacer(modifier = Modifier.padding(horizontal = 4.dp))
                        Text(stringResource(R.string.titulo_game))
                    }

                        },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                )
            )
        }
    ) {
        GameContent(
            // it es el padding que nos llega del Scaffold
            modifier = Modifier.padding(it),
            goResult= goResult,
            player1Value = player1Value,
            player2Value = player2Value,
            player1Click= player1Click,
            player2Click= player2Click,
            escogeGanador = escogeGanador,
        )

    }
}

@Composable
fun GameContent(
    modifier: Modifier,
    goResult: () -> Unit,
    player1Value : Int,
    player2Value:Int,
    player1Click: () -> Unit,
    player2Click: () -> Unit,
    escogeGanador: () -> Unit,
){
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {
        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            //Botón del jugador 1
            Button(
                onClick = player1Click,
                enabled = (player1Value == 0)
            ) {
                Text(stringResource(R.string.j1))
            }
            Spacer(modifier= Modifier.width(8.dp))
            if (player1Value == 0){
                Text(stringResource(R.string.noCard))
            } else {
                Text(stringResource(R.string.valorCarta, player1Value))
            }
        }

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Button(
                onClick = player2Click,
                enabled = (player2Value == 0)
            ) {
                Text(stringResource(R.string.j2))
            }
            Spacer(modifier= Modifier.width(8.dp))
            if (player2Value == 0){
                Text(stringResource(R.string.noCard))
            } else {
                Text(stringResource(R.string.valorCarta, player2Value))
            }
        }
        Button(
            enabled = ((player1Value != 0) and (player2Value != 0)),
            onClick = {
                escogeGanador()
                goResult()
            }
        ) {
            Text(stringResource(R.string.terminar_partida))
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GamePreview() {
    val navController = rememberNavController()
    TestExamenTheme {
        Game({ navController.navigate(route = AppScreens.GameOver.route)}, 0, 0, escogeGanador = {}, player1Click = {}, player2Click = {})
    }
}
