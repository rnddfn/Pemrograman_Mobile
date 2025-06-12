package com.example.retrofit.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.retrofit.data.local.dao.MovieDao

@Database(entities = [com.example.retrofit.data.local.entities.MovieEntity::class], version = 2)
abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}