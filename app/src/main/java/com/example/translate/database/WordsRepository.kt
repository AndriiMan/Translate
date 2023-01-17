package com.example.translate.database


import androidx.lifecycle.LiveData

class WordsRepository(private val wordDao: WordsDao) {

    val readAllData: LiveData<List<Words>> = wordDao.readAllData()

    fun addWord(word: Words) {
        wordDao.addWord(word)
    }

    fun updateWord(word: Words) {
        wordDao.updateWord(word)
    }

}