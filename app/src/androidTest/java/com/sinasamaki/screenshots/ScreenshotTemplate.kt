package com.sinasamaki.screenshots

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sinasamaki.screenshots.ui.theme.ScreenshotsTheme

@Composable
fun ScreenshotTemplate(
    content: @Composable () -> Unit,
) {
    ScreenshotsTheme {
        Column(
            modifier = Modifier
                .verticalScroll(state = rememberScrollState(), reverseScrolling = true)
                .fillMaxSize()
                .background(Color.White)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2000.dp)
                    .padding(horizontal = 30.dp)
                    .clip(RoundedCornerShape(10.dp))
            ) {
                content()
            }

            Text(
                text = "Hello World",
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 94.dp)
            )
        }
    }
}