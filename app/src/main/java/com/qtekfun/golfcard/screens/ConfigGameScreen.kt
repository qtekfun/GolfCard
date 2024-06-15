package com.qtekfun.golfcard.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.qtekfun.golfcard.R
import com.qtekfun.golfcard.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConfigGameScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier.padding(8.dp),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.config_game))
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back),
                        modifier = Modifier.clickable { navController.popBackStack() }
                    )
                }
            )
        }
    )
    {
        innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)){
            ConfigGame(navController)
        }
    }
}

@Composable
fun ConfigGame(navController: NavController) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(horizontalArrangement = Arrangement.Center) {
            Button(onClick = { navController.popBackStack() }) {
                Text(text = stringResource(R.string.back))
            }
            Button(onClick = { navController.navigate(AppScreens.GameScreen.route) }) {
                Text(text = stringResource(R.string.new_game))
            }
        }
    }
}