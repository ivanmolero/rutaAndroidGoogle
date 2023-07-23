package com.imolerodev.a03composebasicdesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imolerodev.a03composebasicdesign.ui.theme.A03ComposeBasicDesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            A03ComposeBasicDesignTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BirthdayGreetingWithImage(
                        message = stringResource(id = R.string.happy_birthday_text),
                        from = stringResource(id = R.string.from_text)
                    )
                }
            }
        }
    }
}

@Composable
fun BirthdayGreetingWithImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.androidparty)
    Box(modifier = modifier) {
        Image(
            painter = image,
            contentDescription = null,
            modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
        BirthdayGreetingWithText(
            message = message,
            from = from
        )
    }
}

@Composable
fun BirthdayGreetingWithText(message: String, from: String, modifier: Modifier = Modifier) {
    Column() {
        Text(
            text = message,
            fontSize = 36.sp,
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.CenterHorizontally)
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp
                )
        )
        Text(
            text = from,
            fontSize = 24.sp,
            modifier = modifier
                .fillMaxWidth()
                .wrapContentWidth(align = Alignment.End)
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp
                )
        )
    }
}

@Preview(name = "Preview", showSystemUi = true)
@Composable
fun BirthdayGreetingWithTextPreview() {
    A03ComposeBasicDesignTheme {
        BirthdayGreetingWithImage(
            message = stringResource(R.string.happy_birthday_text),
            from = stringResource(R.string.from_text)
        )
    }
}