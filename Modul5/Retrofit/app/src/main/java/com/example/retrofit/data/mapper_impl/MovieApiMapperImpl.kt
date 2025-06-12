package com.example.retrofit.data.mapper_impl

import com.example.retrofit.common.data.ApiMapper
import com.example.retrofit.data.remote.models.MovieDto
import com.example.retrofit.domain.models.Movie
import com.example.retrofit.utils.GenreConstants

class MovieApiMapperImpl : ApiMapper<List<Movie>, MovieDto> {
    override fun mapToDomain(apiDto: MovieDto): List<Movie> {
        return apiDto.results?.map { result ->
            Movie(
                backdropPath = formatEmptyValue(result?.backdropPath),
                genreIds = formatGenre(result?.genreIds),
                id = result?.id ?: 0,
                originalLanguage = formatEmptyValue(result?.originalLanguage, default = "language"),
                originalTitle = formatEmptyValue(result?.originalTitle, default = "title"),
                overview = formatEmptyValue(result?.overview, default = "overview"),
                popularity = result?.popularity ?: 0.0,
                posterPath = formatEmptyValue(result?.posterPath),
                releaseDate = formatEmptyValue(result?.releaseDate, default = "date"),
                title = formatEmptyValue(result?.title, default = "title"),
                video = result?.video ?: false,
                voteAverage = result?.voteAverage ?: 0.0,
                voteCount = result?.voteCount ?: 0
            )
        } ?: emptyList()
    }

    private fun formatEmptyValue(value: String?, default: String = ""): String {
        if (value.isNullOrEmpty()) return "Unknown $default"
        return value
    }

    private fun formatGenre(genreIds: List<Int?>?): String {
        return genreIds?.mapNotNull { id ->
            id?.let { GenreConstants.getGenreNameById(it) }
        }?.joinToString(", ") ?: "Unknown Genre"
    }
}