package com.example.moviedetails.data.mapper

import com.example.common.mapper.DomainMapper
import com.example.moviedetails.data.model.MovieDetailDTO
import com.example.moviedetails.domain.model.GenreDomain
import com.example.moviedetails.domain.model.MovieDetailsDomain
import javax.inject.Inject

class MovieDetailsDomainMapper @Inject constructor() :
    DomainMapper<MovieDetailDTO, MovieDetailsDomain> {
    override fun toDomain(entity: MovieDetailDTO): MovieDetailsDomain {
        return MovieDetailsDomain(
            backDropPath = entity.backDropPath.orEmpty(),
            id = entity.id ?: 0,
            overview = entity.overview.orEmpty(),
            releaseDate = entity.releaseDate.orEmpty(),
            title = entity.title.orEmpty(),
            genres = entity.genres?.map {
                GenreDomain(
                    it.id ?: 0,
                    it.name.orEmpty()
                )
            } ?: emptyList()
        )
    }
}
