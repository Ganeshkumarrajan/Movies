package com.example.moviedetails.utils

import com.example.moviedetails.data.model.GenreDTO
import com.example.moviedetails.data.model.MovieDetailDTO
import com.example.moviedetails.data.model.ProductionCompanyDTO
import com.example.moviedetails.data.model.ProductionCountryDTO
import com.example.moviedetails.data.model.SpokenLanguageDTO
import com.example.moviedetails.domain.model.GenreDomain
import com.example.moviedetails.domain.model.MovieDetailsDomain
import com.example.moviedetails.presentation.model.GenreUI
import com.example.moviedetails.presentation.model.MovieDetailsUi

val mockMovieDetailsDomain = MovieDetailsDomain(
    id = 123456,
    overview = "This is a detailed overview of the movie.",
    releaseDate = "2023-01-01",
    title = "The Movie",
    genres = listOf(
        GenreDomain(id = 1, name = "Action"),
        GenreDomain(id = 2, name = "Adventure")
    ),
    backDropPath = "/abc123"
)

val mockMovieDetailsUI = MovieDetailsUi(
    overview = "This is a detailed overview of the movie",
    releaseDate = "2023-01-01",
    title = "The Movie",
    genres = listOf(GenreUI("Action"), GenreUI("Adventure")),
    imageURL = "/abc123"
)

val mockMovieDetailDTO = MovieDetailDTO(
    adult = false,
    backDropPath = "/abc123",
    belongsToCollection = null,
    budget = 10000000,
    genres = listOf(
        GenreDTO(id = 1, name = "Action"),
        GenreDTO(id = 2, name = "Adventure")
    ),
    homepage = "https://www.example.com",
    id = 123456,
    imdbId = "tt1234567",
    originalLanguage = "en",
    originalTitle = "The Original Movie",
    overview = "This is a detailed overview of the movie.",
    popularity = 67.89,
    posterPath = "/def456",
    productionCompanies = listOf(
        ProductionCompanyDTO(
            id = 1,
            logoPath = "/logo1.png",
            name = "Production Company A",
            originCountry = "US"
        ),
        ProductionCompanyDTO(
            id = 2,
            logoPath = "/logo2.png",
            name = "Production Company B",
            originCountry = "CA"
        )
    ),
    productionCountries = listOf(
        ProductionCountryDTO(
            iso = "US",
            name = "United States"
        ),
        ProductionCountryDTO(
            iso = "CA",
            name = "Canada"
        )
    ),
    releaseDate = "2023-01-01",
    revenue = 50000000,
    runtime = 120,
    spokenLanguages = listOf(
        SpokenLanguageDTO(
            englishName = "English",
            iso = "en",
            name = "English"
        ),
        SpokenLanguageDTO(
            englishName = "French",
            iso = "fr",
            name = "Français"
        )
    ),
    status = "Released",
    tagline = "Tagline of the movie",
    title = "The Movie",
    video = false,
    voteAverage = 7.5,
    voteCount = 1000
)

