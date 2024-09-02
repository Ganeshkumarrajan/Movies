package com.example.moviedetails.data.mapper

import com.example.common.mapper.DomainMapper
import com.example.moviedetails.data.model.MovieDetail
import com.example.moviedetails.domain.model.GenreDomain
import com.example.moviedetails.domain.model.MovieDetailsDomain
import javax.inject.Inject

class MovieDetailsDomainMapper @Inject constructor() :
    DomainMapper<MovieDetail, MovieDetailsDomain> {
    override fun toDomain(entity: MovieDetail): MovieDetailsDomain {
        return MovieDetailsDomain(
            backDropPath = entity.backDropPath ?: "",
            id = entity.id ?: 0,
            overview = entity.overview ?: "",
            releaseDate = entity.releaseDate ?: "",
            title = entity.title ?: "",
            genres = entity.genres?.map {
                GenreDomain(
                    it.id ?: 0,
                    it.name ?: ""
                )
            } ?: emptyList()
        )
    }
}
