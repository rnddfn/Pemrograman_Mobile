package com.example.retrofit.common.data

import com.example.retrofit.data.remote.models.MovieDetailDto
import com.example.retrofit.domain.models.MovieDetail

interface MovieDetailMapper {
    fun mapMovieDetailDtoToDomain(dto: MovieDetailDto): MovieDetail
}
