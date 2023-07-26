package com.imolerodev.a03composebasicdesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imolerodev.a03composebasicdesign.ui.theme.A03ComposeBasicDesignTheme

class Excercise01ComposeArticle : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            A03ComposeBasicDesignTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val contenido = listOf(
                        stringResource(R.string.parrafo01_compose_tutorial_text),
                        stringResource(R.string.parrafo02_compose_tutorial_text)
                    )
                    ComposeArticle(
                        title = stringResource(id = R.string.title_compose_tutorial_text),
                        article = contenido
                    )
                }
            }
        }
    }
}

@Composable
fun ComposeArticle(title: String, article: List<String>, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.bg_compose_background)
    Column {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .fillMaxWidth()
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = modifier
                .padding(
                    start = 12.dp,
                    end = 12.dp,
                    top = 16.dp,
                    bottom = 16.dp
                )
        )
        Text(
            text = article[0],
            fontSize = 18.sp,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(
                    start = 12.dp,
                    end = 12.dp,
                )
        )
        Text(
            text = article[1],
            fontSize = 18.sp,
            textAlign = TextAlign.Justify,
            modifier = modifier
                .padding(
                    start = 12.dp,
                    end = 12.dp,
                )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    A03ComposeBasicDesignTheme {
        val contenido = listOf(
            stringResource(R.string.parrafo01_compose_tutorial_text),
            stringResource(R.string.parrafo02_compose_tutorial_text)
        )
        ComposeArticle(
            title = stringResource(id = R.string.title_compose_tutorial_text),
            article = contenido
        )
    }
}