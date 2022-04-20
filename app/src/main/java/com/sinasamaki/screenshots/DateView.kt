package com.sinasamaki.screenshots

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat

@Composable
fun DateView() {

    val today = java.util.Date()

    Row(
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 32.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Text(
            text = SimpleDateFormat("dd").format(today),
            style = MaterialTheme.typography.body1.copy(
                fontSize = 70.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.primary
            )
        )
        Box(modifier = Modifier.width(10.dp))
        Column {
            Text(
                text = SimpleDateFormat("MMM").format(today).uppercase(),
                style = MaterialTheme.typography.body1.copy(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                ),
                modifier = Modifier.alpha(.7f)

            )
            Text(
                text = SimpleDateFormat("YYYY").format(today),
                style = MaterialTheme.typography.body1.copy(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,

                    ),
                modifier = Modifier.alpha(.7f)
            )
        }
        Box(modifier = Modifier.weight(1f))
        Text(
            text = SimpleDateFormat("EEEE").format(today).uppercase(),
            style = MaterialTheme.typography.body1.copy(
                fontSize = 20.sp,
                fontWeight = FontWeight.Light,
            ),
            modifier = Modifier.alpha(.7f)
        )

    }
}