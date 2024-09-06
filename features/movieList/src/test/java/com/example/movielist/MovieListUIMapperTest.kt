package com.example.movielist

import com.example.movielist.domain.model.MovieDomain
import com.example.common.utils.NetWorkConstants
import com.example.movielist.presentaiton.mapper.MovieListUIMapper
import org.junit.Assert.assertEquals
import org.junit.Test

class MovieListUIMapperTest {

    private val movieListUIMapper = MovieListUIMapper()

    @Test
    fun `when invoked with movieDomain verify it returns MovieUI`() {

        val movieDomain = MovieDomain(
            id = 1,
            title = "Test Movie",
            image = "/test_image.jpg",
            year = "2024",
            description = "This is a test movie."
        )

        val movieUIModel = movieListUIMapper.toUiModel(movieDomain)

        // Assert: Verify that the fields are correctly mapped
        assertEquals(movieDomain.id, movieUIModel.id)
        assertEquals(movieDomain.title, movieUIModel.title)
        assertEquals("${NetWorkConstants.IMAGE_BASE_URL_ABSOLUTE}${movieDomain.image}", movieUIModel.image)
        assertEquals(movieDomain.year, movieUIModel.year)
        assertEquals(movieDomain.description, movieUIModel.description)
    }
}
