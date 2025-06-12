package com.example.retrofit.domain.repository

import com.example.retrofit.domain.models.Movie
import com.example.retrofit.domain.models.MovieDetail
import com.example.retrofit.utils.Response
import kotlinx.coroutines.flow.Flow

interface MovieRepository {
    fun fetchDiscoverMovie(): Flow<Response<List<Movie>>>
    fun fetchMovie(movieId: Int): Flow<Response<MovieDetail>>
}