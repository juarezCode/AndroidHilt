package com.juarez.androidhilt.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

data class CharacterList(
    val info: Info,
    val results: List<Character>
)

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)

@Entity(tableName = "characters")
data class Character(
    val created: String,
    val gender: String,
    @PrimaryKey
    val id: Int,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)