package com.example.testexamen.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
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

fun Home(goGame: () -> Unit) {
    Scaffold () {
        HomeContent(
            // it es el padding que nos llega del Scaffold
            modifier = Modifier.padding(it),
            goGame
        )
    }



}



@Composable
fun HomeContent(modifier: Modifier, goGame: () -> Unit) {
    Column (
        modifier= Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(R.string.welcome),
            style = MaterialTheme.typography.titleLarge,
            color= MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = stringResource(R.string.pulsa),
            style = MaterialTheme.typography.bodyLarge,
            color= MaterialTheme.colorScheme.primary
        )
        Spacer(modifier = Modifier.height(4.dp))
        Button(
            onClick = {goGame()}
        ){
            Text(stringResource(R.string.jugar))
            Icon(
                imageVector = Icons.Filled.PlayArrow,
                contentDescription = ""
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    TestExamenTheme {
        Home({ navController.navigate(route = AppScreens.Game.route)})
    }
}
