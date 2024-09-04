package com.example.moviedetails.data.model

import com.squareup.moshi.Json

data class MovieDetailDTO(
    val adult: Boolean?,
    @Json(name = "backdrop_path")
    val backDropPath: String?,
    @Json(name = "belongs_to_collection")
    val belongsToCollection: Any? = null,
    val budget: Int?,
    val genres: List<GenreDTO>?,
    val homepage: String?,
    val id: Int?,
    @Json(name = "imdb_id")
    val imdbId: String?,
    @Json(name = "original_language")
    val originalLanguage: String?,
    @Json(name = "original_title")
    val originalTitle: String?,
    val overview: String?,
    val popularity: Double?,
    @Json(name = "poster_path")
    val posterPath: String?,
    @Json(name = "production_companies")
    val productionCompanies: List<ProductionCompanyDTO>?,
    @Json(name = "production_countries")
    val productionCountries: List<ProductionCountryDTO>?,
    @Json(name = "release_date")
    val releaseDate: String?,
    val revenue: Int?,
    val runtime: Int?,
    @Json(name = "spoken_languages")
    val spokenLanguages: List<SpokenLanguageDTO>?,
    val status: String?,
    val tagline: String?,
    val title: String?,
    val video: Boolean?,
    @Json(name = "vote_average")
    val voteAverage: Double?,
    @Json(name = "vote_count")
    val voteCount: Int?
)
