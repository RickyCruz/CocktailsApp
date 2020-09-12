package com.konztic.tragosapp

import androidx.room.Database
import androidx.room.RoomDatabase
import com.konztic.tragosapp.data.model.DrinkEntity
import com.konztic.tragosapp.domain.DrinkDAO

@Database(entities = [DrinkEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun drinkDAO(): DrinkDAO
}