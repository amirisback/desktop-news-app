// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import mvvm.main.MainScreen

@Composable
fun App() {
    MaterialTheme {
        MainScreen().Create()
    }
}

fun main() = application {
    Window(
        title = "News App",
        onCloseRequest = ::exitApplication,
        state = rememberWindowState(
            width = 900.dp,
            height = 1000.dp,
            position = WindowPosition(alignment = Alignment.Center)
        )
    ) {
        App()
    }
}