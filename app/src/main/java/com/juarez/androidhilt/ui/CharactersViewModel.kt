package com.juarez.androidhilt.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.juarez.androidhilt.models.Character
import com.juarez.androidhilt.repositories.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {
    val characters = MutableLiveData<List<Character>>()

    fun getCharacters() = viewModelScope.launch {
        repository.getCharacters() { isSuccess, data, message ->
            if (isSuccess) characters.value = data
            else {
                Log.e("error", message!!)
            }
        }
    }
}