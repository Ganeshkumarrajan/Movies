package com.example.moviedetails.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviedetails.presentation.model.GenreUI
import com.example.moviedetails.presentation.model.MovieDetailsUIState
import com.example.moviedetails.presentation.model.MovieDetailsUi
import com.example.uielement.views.ChipView
import com.example.uielement.views.ErrorView
import com.example.uielement.views.ImageLoader
import com.example.uielement.views.LabelText
import com.example.uielement.views.SpinnerView
import com.example.uielement.views.SubTitleTextUnlimited
import com.example.uielement.views.TitleText

// Constants for dimension values
private val ImageHeight = 300.dp
private val PaddingSmall = 5.dp
private val PaddingMedium = 10.dp
private val PaddingLarge = 16.dp


@Composable
fun MovieDetailsContent(
    state: MovieDetailsUIState,
    onNavigateBack: () -> Unit,
    onRetry: () -> Unit
) {
    when (state) {
        is MovieDetailsUIState.Error -> ErrorView(
            errorMessage = state.message,
            onRetryClick = onRetry
        ) {}

        MovieDetailsUIState.Loading -> SpinnerView()
        is MovieDetailsUIState.Success -> MovieDetails(
            movie = state.data,
            onNavigateBack = onNavigateBack
        )
    }
}

@Composable
fun MovieDetails(
    movie: MovieDetailsUi,
    onNavigateBack: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                MovieImage(imageUrl = movie.imageURL)
                Spacer(modifier = Modifier.height(PaddingMedium))
            }
            item {
                MovieDetailsContent(movie)
            }
        }

        AddBackButton(
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(PaddingLarge),
            onNavigateBack = onNavigateBack
        )
    }
}

@Composable
fun MovieImage(imageUrl: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(ImageHeight),
        contentAlignment = Alignment.Center
    ) {
        ImageLoader(
            modifier = Modifier.fillMaxSize(),
            image = imageUrl
        )
    }
}

@Composable
fun MovieDetailsContent(movie: MovieDetailsUi) {
    Column(
        modifier = Modifier
            .padding(PaddingLarge)
            .fillMaxWidth()
    ) {
        TitleText(title = movie.title)
        Spacer(modifier = Modifier.height(PaddingSmall))
        LabelText(title = movie.releaseDate)
        Spacer(modifier = Modifier.height(PaddingMedium))
        AddChipViews(genres = movie.genres)
        Spacer(modifier = Modifier.height(PaddingMedium))
        SubTitleTextUnlimited(title = movie.overview)
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun AddChipViews(genres: List<GenreUI>) {
    FlowRow(modifier = Modifier.padding(horizontal = PaddingLarge)) {
        genres.forEach { genre ->
            ChipView(genre.nameString)
        }
    }
}

@Composable
fun AddBackButton(
    modifier: Modifier,
    onNavigateBack: () -> Unit
) {
    Box(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.background,
                shape = CircleShape
            )
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = CircleShape
            )
            .clip(CircleShape)
            .clickable { onNavigateBack() }
            .padding(PaddingSmall)
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back Button",
            tint = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MovieDetailsContentPreview() {
    MaterialTheme {
        MovieDetailsContent(
            state = MovieDetailsUIState.Success(
                MovieDetailsUi(
                    title = "Sample Movie Title",
                    releaseDate = "2024-01-01",
                    imageURL = "https://via.placeholder.com/300",
                    overview = "This is a sample overview of the movie. It gives a brief description of the movie plot.",
                    genres = listOf(
                        GenreUI(nameString = "Action"),
                        GenreUI(nameString = "Adventure"),
                        GenreUI(nameString = "Drama")
                    )
                )
            ),
            onNavigateBack = { },
            onRetry = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MovieDetailsPreview() {
    MaterialTheme {
        MovieDetails(
            movie = MovieDetailsUi(
                title = "Sample Movie Title",
                releaseDate = "2024-01-01",
                imageURL = "https://via.placeholder.com/300",
                overview = "This is a sample overview of the movie. It gives a brief description of the movie plot.",
                genres = listOf(
                    GenreUI(nameString = "Action"),
                    GenreUI(nameString = "Adventure"),
                    GenreUI(nameString = "Drama")
                )
            ),
            onNavigateBack = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AddChipViewsPreview() {
    MaterialTheme {
        AddChipViews(
            genres = listOf(
                GenreUI(nameString = "Action"),
                GenreUI(nameString = "Adventure"),
                GenreUI(nameString = "Drama")
            )
        )
    }
}
