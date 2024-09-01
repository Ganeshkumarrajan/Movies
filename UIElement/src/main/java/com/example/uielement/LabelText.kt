package com.example.uielement

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LabelText(
    modifier: Modifier = Modifier,
    title: String,
) {
    Text(
        modifier = modifier,
        text = title,
        style = MaterialTheme.typography.labelSmall,
        color = MaterialTheme.colorScheme.tertiary,
        fontWeight = FontWeight.SemiBold,
        maxLines = 1,
        textAlign = TextAlign.End
    )

}

@Preview
@Composable
fun PreviewLabelText() {
    MaterialTheme {
        TitleText(title = "This is title")
    }
}