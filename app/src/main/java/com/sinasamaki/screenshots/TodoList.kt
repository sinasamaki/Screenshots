package com.sinasamaki.screenshots

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*

@Composable
fun TodoList() {
    val list = remember {
        when (Locale.getDefault().language) {
            "de" -> {
                mutableStateListOf(
                    Todo("Mom anrufen", false),
                    Todo("Bett machen", false),
                    Todo("5 Seiten lesen", true),
                    Todo("Hund waschen", false),
                    Todo("Arzt termin", false),
                )
            }
            else -> {
                mutableStateListOf(
                    Todo("Call mom", false),
                    Todo("Make the bed", false),
                    Todo("Read 5 pages", true),
                    Todo("Wash the dog", false),
                    Todo("Doctor appointment", false),
                )
            }
        }

    }

    LazyColumn {

        item {
            DateView()
        }

        item {
            Text(
                text = "TASKS",
                modifier = Modifier
                    .alpha(.5f)
                    .padding(horizontal = 16.dp),
                style = MaterialTheme.typography.body1.copy(
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Black,
                    color = MaterialTheme.colors.primary
                )
            )
        }

        itemsIndexed(list) { index, item ->
            TodoListItem(
                Modifier.clickable {
                    list[index] = list[index].copy(
                        checked = !item.checked
                    )
                },
                title = list[index].title,
                checked = list[index].checked,
            )
        }

    }
}

data class Todo(var title: String, var checked: Boolean)
