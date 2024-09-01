package com.example.movielist.domain.model


data class MovieDomain(
    val id: Int,
    val title: String,
    val image: String,
    val year: String,
    val description: String,
)