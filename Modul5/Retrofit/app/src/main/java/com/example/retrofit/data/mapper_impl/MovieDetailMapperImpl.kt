package com.example.retrofit.data.mapper_impl

import com.example.retrofit.common.data.MovieDetailMapper
import com.example.retrofit.data.remote.models.MovieDetailDto
import com.example.retrofit.domain.models.MovieDetail

class MovieDetailMapperImpl : MovieDetailMapper {
    override fun mapMovieDetailDtoToDomain(dto: MovieDetailDto): MovieDetail {
        return MovieDetail(
            id = dto.id ?: -1,
            title = dto.title ?: "",
            overview = dto.overview ?: "",
            posterPath = dto.posterPath ?: "",
            releaseDate = dto.releaseDate ?: "",
            genres = dto.genres?.map { it?.name ?: "Unknown" } ?: listOf("Unknown"),
            voteAverage = dto.voteAverage ?: 0.0,
            voteCount = dto.voteCount ?: 0,
            popularity = dto.popularity ?: 0.0,
            backdropPath = dto.backdropPath ?: "",
            originalLanguage = dto.originalLanguage ?: "Unknown",
            originalTitle = dto.originalTitle ?: "",
            video = dto.video ?: false
        )
    }
}
