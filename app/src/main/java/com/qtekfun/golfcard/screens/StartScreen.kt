package com.qtekfun.golfcard.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.qtekfun.golfcard.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "GolfCard Main Menu")
                }
            )
        }
    )
    {
        BodyContent(navController)
    }
}

@Composable
fun BodyContent(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Main Menu")
        Button(onClick = { navController.navigate(AppScreens.GameScreen.route) }) {
            Text(text = "New Game")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Past Games")
        }
    }
}