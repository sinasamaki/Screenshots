package com.sinasamaki.screenshots

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog

@Composable
fun AddTaskDialog(
    dismiss: () -> Unit
) {
    Dialog(
        onDismissRequest = dismiss
    ) {
        Card(
            shape = RoundedCornerShape(10.dp)
        ) {
            Column {


                Text(
                    text = "ADD TASK",
                    style = MaterialTheme.typography.body1.copy(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.surface
                    ),
                    modifier = Modifier
                        .background(MaterialTheme.colors.primary)
                        .fillMaxWidth()
                        .padding(16.dp)
                )

                TextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth()
                        .padding(16.dp)
                )
                TextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.fillMaxWidth()
                        .padding(16.dp)
                )

            }
        }

    }

}