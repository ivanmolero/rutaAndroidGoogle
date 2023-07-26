package com.imolerodev.a03composebasicdesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.imolerodev.a03composebasicdesign.ui.theme.A03ComposeBasicDesignTheme

class Exercise03ComposeQuadrant : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            A03ComposeBasicDesignTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val titles = listOf(
                        "Text composable",
                        "Image composable",
                        "Row composable",
                        "Column composable"
                    )
                    val contents = listOf(
                        "Displays text and follows the recommended Material Design guidelines.",
                        "Creates a composable that lays out and draws a given Painter class object.",
                        "A layout composable that places its children in a horizontal sequence.",
                        "A layout composable that places its children in a vertical sequence.",
                    )
                    ComposeQuadrant(titles = titles, contents = contents)
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrant(titles: List<String>, contents: List<String>, modifier: Modifier = Modifier) {
    Row(
    ) {
        Column(
            modifier = modifier
                .weight(1f),
        ) {
            Column(
                modifier = modifier
                    .weight(1f)
                    .background(color = Color(0xFFEADDFF))
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = titles[0],
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier
                        .padding(
                            bottom = 16.dp
                        )
                )
                Text(
                    text = contents[0],
                    color = Color.Black,
                    textAlign = TextAlign.Justify,
                )
            }
            Column(
                modifier = modifier
                    .weight(1f)
                    .background(color = Color(0xFFB69DF8))
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = titles[2],
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier
                        .padding(
                            bottom = 16.dp
                        )
                )
                Text(
                    text = contents[2],
                    color = Color.Black,
                    textAlign = TextAlign.Justify,
                )
            }
        }
        Column(
            modifier = modifier
                .weight(1f)
        ) {
            Column(
                modifier = modifier
                    .weight(1f)
                    .background(color = Color(0xFFD0BCFF))
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = titles[1],
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier
                        .padding(
                            bottom = 16.dp
                        )
                )
                Text(
                    text = contents[1],
                    color = Color.Black,
                    textAlign = TextAlign.Justify,
                )
            }
            Column(
                modifier = modifier
                    .weight(1f)
                    .background(color = Color(0xFFF6EDFF))
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = titles[3],
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = modifier
                        .padding(
                            bottom = 16.dp
                        )
                )
                Text(
                    text = contents[3],
                    color = Color.Black,
                    textAlign = TextAlign.Justify,
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview3() {
    A03ComposeBasicDesignTheme {
        val titles = listOf(
            "Text composable",
            "Image composable",
            "Row composable",
            "Column composable"
        )
        val contents = listOf(
            "Displays text and follows the recommended Material Design guidelines.",
            "Creates a composable that lays out and draws a given Painter class object.",
            "A layout composable that places its children in a horizontal sequence.",
            "A layout composable that places its children in a vertical sequence.",
        )
        ComposeQuadrant(titles = titles, contents = contents)
    }
}