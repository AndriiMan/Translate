package com.example.translate.database


import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface WordsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)

    fun addWord(word: Words?)

    @Query("SELECT * FROM word_table ORDER BY id ASC")

    fun readAllData(): LiveData<List<Words>>

    @Update

    fun updateWord(word: Words)
}