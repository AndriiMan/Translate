package com.example.translate.database


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")

data class Words(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val word: String,
    val correctAns: Int,
    val total: Int
)