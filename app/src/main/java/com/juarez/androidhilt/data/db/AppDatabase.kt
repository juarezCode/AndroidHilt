package com.juarez.androidhilt.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.juarez.androidhilt.data.models.User


@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}