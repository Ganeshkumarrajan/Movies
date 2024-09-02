package com.example.moviedetails.mapper

import com.example.common.NetWorkConstants.IMAGE_BASE_URL_MEDIUM_ABSOLUTE
import com.example.common.UIMapper
import com.example.moviedetails.domain.model.MovieDetailsDomain
import com.example.moviedetails.presentation.model.GenreUI
import com.example.moviedetails.presentation.model.MovieDetailsUi
import javax.inject.Inject

class MovieDetailUIMapper @Inject constructor() : UIMapper<MovieDetailsDomain, MovieDetailsUi> {
    override fun toUiModel(entity: MovieDetailsDomain): MovieDetailsUi {
        return MovieDetailsUi(
            genres = entity.genres.map {
                GenreUI( it.name)
            },
            overview = entity.overview,
            releaseDate = entity.releaseDate,
            title = entity.title,
            imageURL = "${IMAGE_BASE_URL_MEDIUM_ABSOLUTE}${entity.backDropPath}"
        )
    }
}