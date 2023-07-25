package com.example.newswithcleancode.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun OptionsMenuScreen(
    options: List<String>,
    currentOption: Int,
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    onSelect: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(0.2f))
            .clickable { onDismiss() }
            .then(modifier),
        contentAlignment = Alignment.Center
    ) {
        RadioButtons(
            options = options,
            currentOption = currentOption
        ) { onSelect(it); onDismiss() }
    }
}

@Composable
fun OptionsMenuButton(
    text: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onOpen: () -> Unit
) {
    OutlinedButton(
        onClick = onOpen,
        modifier = modifier,
        enabled = enabled
    ) {
        Text(text)
    }
}