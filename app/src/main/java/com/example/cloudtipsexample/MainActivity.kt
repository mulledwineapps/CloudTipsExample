package com.example.cloudtipsexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.cloudtipsexample.ui.theme.CloudTipsExampleTheme
import ru.cloudtips.sdk.TipsManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CloudTipsExampleTheme {
                Content()
            }
        }
    }
}

@Composable
fun Content(modifier: Modifier = Modifier) {
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        val context = LocalContext.current
        Button(
            onClick = {
                TipsManager
                    .getInstance(context)
                    .launch("4bba4a70", null)
            },
            modifier = Modifier.wrapContentSize()
        ) {
            Text(text = "Запустить оплату чаевых")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CloudTipsExampleTheme {
        Content()
    }
}