package com.konztic.tragosapp.domain

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.konztic.tragosapp.data.model.DrinkEntity

interface DrinkDAO {
    @Query("SELECT * FROM DrinkEntity")
    suspend fun getAllFavoriteDrinks(): List<DrinkEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(drink: DrinkEntity)
}