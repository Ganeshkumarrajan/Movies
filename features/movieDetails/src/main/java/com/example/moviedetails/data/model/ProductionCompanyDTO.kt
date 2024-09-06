package com.example.moviedetails.data.model

import com.squareup.moshi.Json

data class ProductionCompanyDTO(
    val id: Int?,
    @Json(name = "logo_path")
    val logoPath: String?,
    val name: String?,
    @Json(name = "origin_country")
    val originCountry: String?
)
