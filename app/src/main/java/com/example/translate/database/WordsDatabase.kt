//ARSALAN SHAKIL
//1910097
package com.example.translate.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [Words::class], version = 1, exportSchema = false
)

abstract class WordsDatabase : RoomDatabase() {

    abstract fun wordDao(): WordsDao

    companion object {
        @Volatile
        private var INSTANCE: WordsDatabase? = null


        fun getDatabase(context: Context): WordsDatabase {
            val tempInstance = INSTANCE

            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordsDatabase::class.java,
                    "word_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}