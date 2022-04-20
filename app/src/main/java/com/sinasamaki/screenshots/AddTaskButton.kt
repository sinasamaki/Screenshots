package com.sinasamaki.screenshots

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddTaskButton() {

    var showAddTaskDialog by remember { mutableStateOf(false) }
    if (showAddTaskDialog) AddTaskDialog(dismiss = { showAddTaskDialog = false })

    Box(
        modifier = Modifier
            .shadow(
                elevation = 5.dp,
                shape = RoundedCornerShape(50.dp)
            )
            .background(
                color = MaterialTheme.colors.secondary,
                shape = RoundedCornerShape(50.dp)
            )
            .clip(
                shape = RoundedCornerShape(50.dp)
            )
            .clickable { showAddTaskDialog = true }
            .padding(10.dp)

    ) {
        Row(
            modifier = Modifier.padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {

            Icon(
                imageVector = Icons.Rounded.Add,
                contentDescription = "add task",
                tint = MaterialTheme.colors.onSecondary,
            )

            Box(modifier = Modifier.width(8.dp))

            Text(
                text = stringResource(id = R.string.add_task),
                color = MaterialTheme.colors.onSecondary,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
            )
        }
    }
}