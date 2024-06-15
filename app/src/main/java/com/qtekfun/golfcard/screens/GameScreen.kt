package com.qtekfun.golfcard.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.qtekfun.golfcard.R
import com.qtekfun.golfcard.navigation.AppScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier.padding(8.dp),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.golf_play))
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back),
                        modifier = Modifier.clickable { navController.navigate(AppScreens.StartScreen.route) }
                    )
                }
            )
        }
    )
    {
        innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)){
            GolfGame(navController)
        }
    }
}

@Composable
fun GolfGame(navController: NavController, holes: Int = 18) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for (i in 1..holes) {
            Hole(i)
        }
        Row(horizontalArrangement = Arrangement.Center) {
            Button(onClick = { navController.navigate(AppScreens.StartScreen.route) }) {
                Text(text = stringResource(R.string.back))
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = stringResource(R.string.save_game))
            }
        }
    }
}

@Composable
fun NumberInput(initialValue: Int, onValueChange: (Int) -> Unit) {

    var currentValue by remember { mutableIntStateOf(initialValue) }

    Row(horizontalArrangement = Arrangement.Center) {
        Button(onClick = {
            currentValue--
            onValueChange(currentValue)
        }) {
            Icon(Icons.Default.KeyboardArrowDown, contentDescription = "Decrement")
        }
        Spacer(modifier = Modifier.width(40.dp))
        Text(text = currentValue.toString(), style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.width(40.dp))
        Button(onClick = {
            currentValue++
            onValueChange(currentValue)
        }) {
            Icon(Icons.Default.KeyboardArrowUp, contentDescription = "Increment")
        }
    }
}

@Composable
fun HoleData(text: String, style: TextStyle) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text,
            style = style,
            color = MaterialTheme.colorScheme.primary
        )
        NumberInput(initialValue = 0) {
        }
    }
}

@Composable
fun Hole(number: Int = 0) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(4.dp)
            .fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.primary)
                .padding(8.dp),
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "Test Image"
        )
        Spacer(modifier = Modifier.width(6.dp))
        HoleData(stringResource(R.string.hole_number) + " $number", MaterialTheme.typography.labelLarge)
    }
}