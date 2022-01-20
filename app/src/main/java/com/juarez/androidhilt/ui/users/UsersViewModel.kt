package com.juarez.androidhilt.ui.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.juarez.androidhilt.data.models.User
import com.juarez.androidhilt.data.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val repository: UserRepository
) : ViewModel() {

    val users = repository.allUsers.asLiveData()

    fun saveUser(user: User) = viewModelScope.launch {
        repository.saveUserDB(user)
    }

    fun deleteUsers() = viewModelScope.launch {
        repository.deleteUsers()
    }
}