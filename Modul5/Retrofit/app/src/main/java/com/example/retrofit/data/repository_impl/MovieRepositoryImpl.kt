package com.example.retrofit.data.repository_impl

import com.example.retrofit.common.data.ApiMapper
import com.example.retrofit.common.data.MovieDetailMapper
import com.example.retrofit.data.local.dao.MovieDao
import com.example.retrofit.data.local.mapper.toDomain
import com.example.retrofit.data.local.mapper.toEntity
import com.example.retrofit.data.remote.api.MovieApiService
import com.example.retrofit.data.remote.models.MovieDto
import com.example.retrofit.domain.models.Movie
import com.example.retrofit.domain.repository.MovieRepository
import com.example.retrofit.utils.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import com.example.retrofit.domain.models.MovieDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepositoryImpl(
    private val movieApiService: MovieApiService,
    private val apiMapper: ApiMapper<List<Movie>, MovieDto>,
    private val movieDetailMapper: MovieDetailMapper,
    private val movieDao: MovieDao
) : MovieRepository {
    override fun fetchDiscoverMovie(): Flow<Response<List<Movie>>> = flow {
        emit(Response.Loading())

        val cachedMovies = movieDao.getAllMovies().map { it.toDomain() }
        if (cachedMovies.isNotEmpty()) {
            emit(Response.Success(cachedMovies))
        }

        try {
            val movieDto = movieApiService.fetchDiscoverMovie()
            val movies = apiMapper.mapToDomain(movieDto)

            withContext(Dispatchers.IO) {
                movieDao.clearAll()
                movieDao.insertMovies(movies.map { it.toEntity() })
            }

            emit(Response.Success(movies))

        } catch (e: Exception) {
            if (cachedMovies.isEmpty()) {
                emit(Response.Error(e))
            }
        }
    }

    override fun fetchMovie(movieId: Int): Flow<Response<MovieDetail>> = flow {
        emit(Response.Loading())
        try {
            val dto = movieApiService.fetchMovie(movieId)
            val movie = movieDetailMapper.mapMovieDetailDtoToDomain(dto)
            emit(Response.Success(movie))
        } catch (e: Exception) {
            emit(Response.Error(e))
        }
    }
}