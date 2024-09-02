package com.example.moviedetails.presentation.model

data class MovieDetailsUi(
    val overview: String,
    val releaseDate: String,
    val title: String,
    val genres: List<GenreUI>,
    val imageURL: String,
)

data class GenreUI(
    val nameString: String
)
