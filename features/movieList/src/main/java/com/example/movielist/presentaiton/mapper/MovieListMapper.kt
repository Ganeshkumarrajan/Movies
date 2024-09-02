package com.example.movielist.presentaiton.mapper

import com.example.common.NetWorkConstants
import com.example.common.UIMapper
import com.example.movielist.domain.model.MovieDomain
import com.example.movielist.presentaiton.model.MovieUIModel
import javax.inject.Inject

class MovieListUIMapper @Inject constructor() : UIMapper<MovieDomain, MovieUIModel> {
    override fun toUiModel(entity: MovieDomain): MovieUIModel =
        MovieUIModel(
            id = entity.id,
            title = entity.title,
            image = "${NetWorkConstants.IMAGE_BASE_URL_ABSOLUTE}${entity.image}",
            year = entity.year,
            description = entity.description
        )
}
