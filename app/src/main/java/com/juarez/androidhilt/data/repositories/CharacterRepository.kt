package com.juarez.androidhilt.data.repositories

import com.juarez.androidhilt.data.api.CharacterAPI
import com.juarez.androidhilt.data.models.Character
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val characterAPI: CharacterAPI,
) {

    suspend fun getCharacters(
        callback: (isSuccess: Boolean, data: List<Character>?, message: String?) -> Unit
    ) {
        try {
            val response = characterAPI.getAllCharacters()

            if (response.isSuccessful) {
                callback.invoke(true, response.body()!!.results, null)
            } else throw Exception("Un error ah ocurrido")
        } catch (e: Exception) {
            callback.invoke(false, null, e.message.toString())
        }
    }

}