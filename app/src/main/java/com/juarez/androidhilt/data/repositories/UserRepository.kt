package com.juarez.androidhilt.data.repositories

import com.juarez.androidhilt.data.db.UserDao
import com.juarez.androidhilt.data.models.User
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val userDao: UserDao
) {

    suspend fun saveUserDB(user: User) = userDao.insert(user)

    suspend fun deleteUsers() = userDao.deleteAllUsers()

    val allUsers = userDao.getAllUsers()
}