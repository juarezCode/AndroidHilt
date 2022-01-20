package com.juarez.androidhilt.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.juarez.androidhilt.data.models.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    @Query("SELECT * from users_table")
    fun getAllUsers(): Flow<List<User>>

    @Query("DELETE from users_table")
    suspend fun deleteAllUsers()
}