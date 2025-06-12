package com.example.retrofit.data.local.dao

import androidx.room.*
import com.example.retrofit.data.local.entities.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movies ORDER BY popularity DESC")
    suspend fun getAllMovies(): List<MovieEntity>

    @Query("SELECT * FROM movies ORDER BY popularity DESC")
    fun getAllMoviesFlow(): Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieEntity>)

    @Query("DELETE FROM movies")
    suspend fun clearAll()

    @Query("SELECT COUNT(*) FROM movies")
    suspend fun getMoviesCount(): Int
}