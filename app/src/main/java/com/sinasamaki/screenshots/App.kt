package com.sinasamaki.screenshots

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Create
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@ExperimentalAnimationApi
@Composable
fun App() {

    val bottomNavItems = listOf(
        Screen.Tasks,
        Screen.Inbox,
        Screen.Settings,
    )

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            bottomBar = {
                BottomNav(screens = bottomNavItems)
            },
            floatingActionButton = {
                AddTaskButton()
            },
            floatingActionButtonPosition = FabPosition.End,
        ) {
            Box(modifier = Modifier.padding(it)) {
                TodoList()
            }
        }
    }
}

sealed class Screen(
    val title: String,
    val activeIcon: ImageVector,
    val inactiveIcon: ImageVector
) {
    object Tasks : Screen("Tasks", Icons.Filled.Create, Icons.Outlined.Create)
    object Inbox : Screen("Inbox", Icons.Filled.DateRange, Icons.Outlined.DateRange)
    object Settings : Screen("Settings", Icons.Filled.Settings, Icons.Outlined.Settings)
}