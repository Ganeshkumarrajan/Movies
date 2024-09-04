package com.example.moviedetails.data.model

import com.squareup.moshi.Json

data class ProductionCountryDTO(
    @Json(name = "iso_3166_1")
    val iso: String?,
    val name: String?
)
