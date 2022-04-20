package com.sinasamaki.screenshots

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

@Composable
fun TodoListItem(
    modifier: Modifier = Modifier,
    title: String,
    checked: Boolean,
) {
    Row(
        modifier = modifier
            .alpha(if (checked) .5f else 1f)
            .padding(16.dp)
    ) {
        Text(
            text = title,
            textDecoration = if (checked) TextDecoration.LineThrough else TextDecoration.None,
            style = MaterialTheme.typography.body1.copy(

            )
        )
        Box(modifier = Modifier.weight(1f))
        Box(
            modifier = Modifier
                .size(20.dp)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colors.primary,
                    shape = CircleShape
                ),
        ) {
            if (checked) Icon(
                modifier = Modifier.background(
                    shape = CircleShape,
                    color = MaterialTheme.colors.primary
                ),
                imageVector = Icons.Rounded.Check,
                contentDescription = "check",
                tint = MaterialTheme.colors.surface,
            )
        }
    }
}