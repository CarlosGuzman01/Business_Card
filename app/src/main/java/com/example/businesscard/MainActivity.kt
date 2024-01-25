package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val fontName  = GoogleFont("Roboto Mono")

val fontFamily = FontFamily(
    Font(
        googleFont = fontName,
        fontProvider = provider
    )
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    val appBackground = Color(0xFFd2e8d4)

    Column(modifier = modifier.background(appBackground), verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally) {

        FirstComposable(
            stringResource(R.string.full_name),
            stringResource(R.string.job_title),
            modifier
        )

        IconsComposable(
            value = stringResource(R.string.my_phone_number),
            iconVector = Icons.Default.Call,
            modifier = modifier
        )
        
        IconsComposable(
            value = stringResource(R.string.github),
            iconVector = Icons.Default.Share,
            modifier = modifier
        )
        
        IconsComposable(
            value = stringResource(R.string.email),
            iconVector = Icons.Default.Email,
            modifier = modifier
        )
        
        Spacer(modifier = Modifier.height(80.dp))
    }
}

@Composable
fun FirstComposable(name: String, title: String,  modifier: Modifier){

    val painter = painterResource(R.drawable.android_logo)
    val imageColor = Color(0xFF073042) // hexcode before #073042
    val jobTitleColor = Color(0xFF35C07C)



    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Image(
            painter = painter,
            contentDescription = null,
            Modifier
                .background(imageColor)
                .size(150.dp)
        )

        Text(
            text = name,
            color =  Color.Black,
            fontSize = 30.sp,
            fontFamily = fontFamily
        )

        Text(
            text = title,
            color = jobTitleColor
        )
        
       Spacer(modifier = Modifier.height(300.dp))  /////////////
    }
}

@Composable
fun IconsComposable(value: String, iconVector: ImageVector, modifier: Modifier){

    val iconsColor = Color(0xFF35C07C)

    Row(verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.End) {
        Icon(
            imageVector = iconVector, // Replace with the desired icon
            contentDescription = null,
            tint = iconsColor,
            modifier = modifier.padding(end = 10.dp)// You can specify the color of the icon
        )

        Text(
            text = value,
            color = Color.Black
        )
        
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}