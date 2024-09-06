package com.example.movielist.presentaiton.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.movielist.R
import com.example.movielist.presentaiton.model.MovieUIModel
import com.example.uielement.views.ErrorView
import com.example.uielement.views.ImageLoader
import com.example.uielement.views.LabelText
import com.example.uielement.views.SpinnerView
import com.example.uielement.views.SpinnerViewWithText
import com.example.uielement.views.SubTitleText
import com.example.uielement.views.TitleText

@Composable
fun MoviesContent(
    modifier: Modifier = Modifier,
    movies: LazyPagingItems<MovieUIModel>,
    onNavigateDetailScreen: (String) -> Unit
) {
    val listState = rememberLazyListState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        AddMovieList(
            movies = movies,
            listState = listState,
            onNavigateDetailScreen = onNavigateDetailScreen
        )

        AddMovieLoadingState(movies = movies)
    }
}

@Composable
fun AddMovieList(
    movies: LazyPagingItems<MovieUIModel>,
    listState: LazyListState,
    onNavigateDetailScreen: (String) -> Unit
) {
    if (movies.itemCount > 0) {
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
        ) {
            items(movies.itemCount) { index ->
                movies[index]?.let { movie ->
                    AddMovieItem(
                        movie = movie,
                        modifier = Modifier
                            .animateItem(fadeInSpec = null, fadeOutSpec = null)
                            .padding(8.dp),
                        onNavigateDetailScreen = onNavigateDetailScreen
                    )
                }
            }
        }
    }
}

@Composable
fun AddMovieLoadingState(movies: LazyPagingItems<MovieUIModel>) {
    Box(modifier = Modifier.fillMaxSize()) {
        when (val refreshState = movies.loadState.refresh) {
            is LoadState.Loading -> SpinnerViewWithText()

            is LoadState.Error -> {
                var showDialog by remember { mutableStateOf(true) }
                if (showDialog) {
                    ErrorView(
                        errorMessage = refreshState.error.localizedMessage
                            ?: stringResource(R.string.error_occurred),
                        onRetryClick = { movies.retry() },
                        onDismiss = { showDialog = false }
                    )
                }
            }

            else -> Unit
        }

        if (movies.loadState.append is LoadState.Loading) {
            SpinnerView(modifier = Modifier.align(Alignment.BottomCenter))
        }
    }
}

@Composable
private fun AddMovieItem(
    movie: MovieUIModel,
    modifier: Modifier = Modifier,
    onNavigateDetailScreen: (String) -> Unit
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .clickable {
                    onNavigateDetailScreen(movie.id.toString())
                }
                .padding(16.dp),
        ) {
            AddMovieImage(movie)
            Spacer(modifier = Modifier.width(10.dp))
            Column {
                TitleText(title = movie.title)
                SubTitleText(title = movie.description)
                LabelText(
                    title = movie.year,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
        }
    }
}

@Composable
private fun AddMovieImage(movie: MovieUIModel) {
    ImageLoader(
        Modifier
            .size(100.dp, 150.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color.LightGray),
        movie.image,
    )
}

@Preview(showBackground = true)
@Composable
fun MovieItemPreview() {
    val movie = MovieUIModel(
        id = 1,
        title = "Sample Movie",
        description = "This is a sample movie description.",
        year = "2026",
        image = "https://test"
    )
    AddMovieItem(
        movie = movie,
        modifier = Modifier
    ) {}
}

@Preview(showBackground = true)
@Composable
fun MovieImagePreview() {
    val movie = MovieUIModel(
        id = 1,
        title = "Sample Movie",
        description = "This is a sample movie description.",
        year = "2026",
        image = "https://test"
    )
    AddMovieImage(movie = movie)
}
