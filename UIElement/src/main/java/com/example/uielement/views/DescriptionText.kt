package com.example.uielement.views

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun SubTitleText(
    modifier: Modifier = Modifier,
    title: String,
) {
    Text(
        modifier = modifier,
        text = title,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.tertiary,
        fontWeight = FontWeight.Normal,
        maxLines = 3,
        fontSize = 14.sp
    )
}

@Composable
fun SubTitleTextUnlimited(
    modifier: Modifier = Modifier,
    title: String,
) {
    Text(
        modifier = modifier,
        text = title,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.tertiary,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    )
}

@Preview
@Composable
fun PreviewSubTitleText() {
    MaterialTheme {
        TitleText(title = "This is title")
    }
}