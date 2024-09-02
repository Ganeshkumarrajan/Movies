package com.example.moviedetails.utils

import com.example.moviedetails.domain.model.GenreDomain
import com.example.moviedetails.domain.model.MovieDetailsDomain
import com.example.moviedetails.presentation.model.GenreUI
import com.example.moviedetails.presentation.model.MovieDetailsUi

val mockMovieDetail = MovieDetailsDomain(
    id = 1,
    overview = "descrption",
    releaseDate = "11-11-2026",
    title = "title",
    genres = listOf(GenreDomain(1, "")),
    backDropPath = ""

)

val mockMovieDetailsUI = MovieDetailsUi(
    overview = "descrption",
    releaseDate = "11-11-2026",
    title = "title",
    genres = listOf(GenreUI("")),
    imageURL = ""
)
