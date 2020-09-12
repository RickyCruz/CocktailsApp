package com.konztic.tragosapp.domain

import androidx.room.*
import com.konztic.tragosapp.data.model.Drink
import com.konztic.tragosapp.data.model.DrinkEntity

@Dao
interface DrinkDAO {

    @Query("SELECT * FROM DrinkEntity")
    suspend fun getAllFavoriteDrinks(): List<DrinkEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavorite(drink: DrinkEntity)

    @Delete
    suspend fun deleteFavorite(drink: DrinkEntity)
}