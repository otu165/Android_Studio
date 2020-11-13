package com.example.jetpackprac.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jetpackprac.model.Text

@Database(entities = [Text::class], version = 1)
abstract class TextDatabase : RoomDatabase() {
    abstract fun textDao() : TextDao
}