package com.example.retrofit.domain.models

data class MovieDetail(
    val id: Int,
    val title: String,
    val overview: String,
    val posterPath: String,
    val releaseDate: String,
    val genres: List<String>,
    val voteAverage: Double,
    val voteCount: Int,
    val popularity: Double,
    val backdropPath: String,
    val originalLanguage: String,
    val originalTitle: String,
    val video: Boolean
)
