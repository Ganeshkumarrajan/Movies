package com.example.moviedetails.domain.model

data class MovieDetailsDomain(
    val id: Int,
    val overview: String,
    val releaseDate: String,
    val title: String,
    val genres: List<GenreDomain>,
    val backDropPath: String,
)

data class GenreDomain(
    val id: Int,
    val name: String
)
