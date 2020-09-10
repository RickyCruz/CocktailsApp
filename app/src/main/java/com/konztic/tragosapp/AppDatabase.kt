package com.konztic.tragosapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.konztic.tragosapp.data.model.DrinkEntity
import com.konztic.tragosapp.domain.DrinkDAO

@Database(entities = [ DrinkEntity::class ], version = 1 )
abstract class AppDatabase : RoomDatabase() {
    abstract fun drinkDAO() : DrinkDAO

    companion object {
        private var INSTANCE : AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            INSTANCE = INSTANCE ?: Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "t_drinks").build()

            return INSTANCE!!
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}