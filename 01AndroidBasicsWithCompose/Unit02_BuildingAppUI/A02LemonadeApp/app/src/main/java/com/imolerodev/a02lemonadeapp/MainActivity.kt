package com.imolerodev.a02lemonadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imolerodev.a02lemonadeapp.ui.theme.A02LemonadeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            A02LemonadeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@Composable
fun LemonadeWithImages(modifier: Modifier = Modifier) {
    var squeeze by remember {
        mutableStateOf(0)
    }
    var result by remember {
        mutableStateOf(0)
    }
    val imageResource = when (result) {
        0 -> R.drawable.lemon_tree
        1 -> R.drawable.lemon_squeeze
        2 -> R.drawable.lemon_drink
        3 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_tree
    }
    val stringResources = when (result) {
        0 -> R.string.tap_lemon_tree
        1 -> R.string.tap_squeeze_lemon
        2 -> R.string.tap_drink_lemonade
        3 -> R.string.tap_empty_glass
        else -> R.string.tap_lemon_tree
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(
            onClick = {
                when (result) {
                    0 -> squeeze = (2..4).random()
                    1 -> {
                        if (squeeze > 0) {
                            squeeze--
                            result--
                        }
                    }
                }
                result++
                result %= 4
            },
            shape = RoundedCornerShape(20.dp)
        ) {
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = null
            )
        }
        Text(
            text = stringResource(id = stringResources),
            modifier = Modifier
                .padding(
                    top = 16.dp
                )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LemonadeApp() {
    A02LemonadeAppTheme {
        LemonadeWithImages(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(Alignment.Center)
        )
    }
}