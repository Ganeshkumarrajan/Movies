package com.example.movielist.data.mapper

import com.example.common.DomainMapper
import com.example.movielist.data.model.ResultDTO
import com.example.movielist.domain.model.MovieDomain
import javax.inject.Inject

class MovieListMapper @Inject constructor() : DomainMapper<ResultDTO, MovieDomain> {
    override fun toDomain(entity: ResultDTO): MovieDomain =
        MovieDomain(
            id = entity.id, title = entity.title ?: "",
            image = entity.posterPath ?: "",
            description = entity.overview ?: "",
            year = entity.releaseDate ?: ""
        )
}
