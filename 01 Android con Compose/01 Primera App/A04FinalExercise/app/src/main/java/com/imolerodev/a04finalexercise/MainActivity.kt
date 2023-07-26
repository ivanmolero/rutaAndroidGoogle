package com.imolerodev.a04finalexercise

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.imolerodev.a04finalexercise.ui.theme.A04FinalExerciseTheme
import kotlinx.coroutines.processNextEventInCurrentThread

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            A04FinalExerciseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard(
                        fullName = stringResource(id = R.string.full_name_card),
                        title = stringResource(id = R.string.title_card),
                        phoneNumber = stringResource(R.string.phone_number_card),
                        nickName = stringResource(R.string.nick_name_card),
                        email = stringResource(R.string.email_card)
                    )
                }
            }
        }
    }
}

@Composable
fun BusinessCard(fullName: String,
                 title: String,
                 phoneNumber: String,
                 nickName: String,
                 email: String,
                 modifier: Modifier = Modifier) {
    Box (
        modifier = modifier
            .background(Color(0xFFC3DBB5))
    ) {
        FullNameTitleArea(
            fullName = fullName,
            title = title,
            modifier = modifier
                .align(Center)
        )
        ContactInformationArea(
            phoneNumber = phoneNumber,
            nickName = nickName,
            email = email,
            modifier = modifier
                .align(BottomCenter)
        )
    }
}

@Composable
fun FullNameTitleArea(fullName: String, title: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.android_logo)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = modifier
                .height(100.dp)
                .background(Color(0xFF293952))
        )
        Text(
            text = fullName,
            color = Color.Black,
            fontSize = 36.sp,
            textAlign = TextAlign.Center,
            modifier = modifier
                .fillMaxWidth()
        )
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF204710),
            modifier = modifier
                .fillMaxWidth()
        )
    }
}

@Composable
fun ContactInformationArea(phoneNumber: String, nickName: String, email: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .padding(
                bottom = 22.dp
            )
            .width(IntrinsicSize.Max)
    ) {
        ContactInformationItem(
            idIcon = R.drawable.phone_icon_card,
            detail = phoneNumber)
        ContactInformationItem(
            idIcon = R.drawable.share_icon_card,
            detail = nickName)
        ContactInformationItem(
            idIcon = R.drawable.email_icon_card,
            detail = email)
    }
}

@Composable
fun ContactInformationItem(idIcon: Int, detail: String, modifier: Modifier = Modifier) {
    val icon = painterResource(id = idIcon)
    Row(
        modifier = modifier
    ) {
        Icon(
            painter = icon,
            contentDescription = null,
            tint = Color(0xFF204710),
            modifier = modifier
                .height(22.dp)
                .padding(
                    end = 16.dp
                )
        )
        Text(
            text = detail,
            color = Color.Black,
            textAlign = TextAlign.Start,
            modifier = modifier
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    A04FinalExerciseTheme {
        BusinessCard(
            fullName = stringResource(id = R.string.full_name_card),
            title = stringResource(id = R.string.title_card),
            phoneNumber = stringResource(R.string.phone_number_card),
            nickName = stringResource(R.string.nick_name_card),
            email = stringResource(R.string.email_card)
        )
    }
}