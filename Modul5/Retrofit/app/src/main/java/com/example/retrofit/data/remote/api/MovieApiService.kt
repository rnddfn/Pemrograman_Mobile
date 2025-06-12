package com.example.retrofit.data.remote.api

import com.example.retrofit.BuildConfig
import com.example.retrofit.data.remote.models.MovieDetailDto
import com.example.retrofit.data.remote.models.MovieDto
import com.example.retrofit.utils.K
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {

    @GET(K.MOVIE_ENDPOINT)
    suspend fun fetchDiscoverMovie(
        @Query("api_key") apiKey: String = BuildConfig.apiKey,
        @Query("include_adult") includeAdult: Boolean = false
    ): MovieDto

    @GET("movie/{movie_id}")
    suspend fun fetchMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String = BuildConfig.apiKey
    ): MovieDetailDto
}
