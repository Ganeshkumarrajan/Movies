package com.example.movielist.presentaiton.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import com.example.movielist.R
import com.example.movielist.presentaiton.model.MovieUIModel
import com.example.uielement.*

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MoviesContent(
    moviePagingItem: LazyPagingItems<MovieUIModel>,
    modifier: Modifier = Modifier,
) {
    var showDialog by remember { mutableStateOf(true) }
    val listState = rememberLazyListState()

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        if (moviePagingItem.itemCount > 0) {
            LazyColumn(
                state = listState,
                modifier = Modifier.fillMaxSize(),
            ) {
                items(moviePagingItem.itemCount) { index ->
                    moviePagingItem[index]?.let { movie ->
                        MovieItem(
                            movie = movie,
                            modifier = Modifier
                                .animateItemPlacement()
                                .fillMaxWidth()
                                .padding(8.dp)
                        )
                    }
                }
            }
        }

        when (val refreshState = moviePagingItem.loadState.refresh) {
            is LoadState.Loading -> SpinnerViewWithText()
            is LoadState.Error -> {
                AnimatedVisibility(visible = showDialog) {
                    ErrorView(
                        errorMessage = refreshState.error.localizedMessage
                            ?: stringResource(R.string.error_occurred),
                        onRetryClick = { moviePagingItem.retry() },
                        onDismiss = { showDialog = false }
                    )
                }
            }

            else -> Unit
        }

        if (moviePagingItem.loadState.append is LoadState.Loading) {
            SpinnerView(modifier = Modifier.align(Alignment.BottomCenter))
        }
    }
}

@Composable
private fun MovieItem(
    movie: MovieUIModel,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .clickable { /* Handle click here */ }
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            MovieImage(movie)
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
private fun MovieImage(movie: MovieUIModel) {
    ImageLoader(movie.image)
}


@Preview(showBackground = true)
@Composable
fun MovieItemPreview() {
    val movie = MovieUIModel(
        id = 1,
        title = "Sample Movie",
        description = "This is a sample movie description.",
        year = "2023",
        image = "https://test"
    )
    MovieItem(movie = movie)
}

@Preview(showBackground = true)
@Composable
fun MovieImagePreview() {
    val movie = MovieUIModel(
        id = 1,
        title = "Sample Movie",
        description = "This is a sample movie description.",
        year = "2023",
        image = "https://test"
    )
    MovieImage(movie = movie)
}
