package com.example.common.utils

import com.example.common.BuildConfig

object NetWorkConstants {
    // replace API key with valid API key
    const val API_KEY = BuildConfig.API_KEY
    const val BASE_URL: String = BuildConfig.BASE_URL
    const val LANGUAGE = "en-US"
    const val PAGE_SIZE = 10
    const val IMAGE_BASE_URL_ABSOLUTE = "https://image.tmdb.org/t/p/w300/"
    const val IMAGE_BASE_URL_MEDIUM_ABSOLUTE = "https://image.tmdb.org/t/p/w500/"
    const val MOVIE_ID = "movieID"
}
