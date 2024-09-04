package com.example.movielist.data.mapper

import com.example.common.mapper.DomainMapper
import com.example.movielist.data.model.ResultDTO
import com.example.movielist.domain.model.MovieDomain
import javax.inject.Inject

class MovieListMapper @Inject constructor() : DomainMapper<ResultDTO, MovieDomain> {
    override fun toDomain(entity: ResultDTO): MovieDomain =
        MovieDomain(
            id = entity.id, title = entity.title.orEmpty(),
            image = entity.posterPath.orEmpty(),
            description = entity.overview.orEmpty(),
            year = entity.releaseDate.orEmpty()
        )
}
