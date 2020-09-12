package com.konztic.tragosapp.domain

import com.konztic.tragosapp.data.model.Drink
import com.konztic.tragosapp.data.model.DrinkEntity
import com.konztic.tragosapp.vo.Resource

interface DataSource {
    suspend fun getDrinkByName(name: String): Resource<List<Drink>>

    suspend fun getFavoriteDrinks(): Resource<List<DrinkEntity>>

    suspend fun insertDrinkRoom(drink: DrinkEntity)

    suspend fun deleteDrinkRoom(drink: DrinkEntity)
}