package com.konztic.tragosapp.data

import com.konztic.tragosapp.AppDatabase
import com.konztic.tragosapp.data.model.Drink
import com.konztic.tragosapp.data.model.DrinkEntity
import com.konztic.tragosapp.vo.Resource
import com.konztic.tragosapp.vo.RetrofitClient

class DataSource(private val appDatabase: AppDatabase) {

    suspend fun getDrinkByName(name: String): Resource<List<Drink>> {
        return Resource.Success(
            RetrofitClient.webservice.getDrinkByName(name).drinkList
        )
    }

    suspend fun insertDrinkRoom(drink: DrinkEntity) {
        appDatabase.drinkDAO().addFavorite(drink)
    }

    suspend fun getFavoriteDrinks(): Resource<List<DrinkEntity>> {
        return Resource.Success(appDatabase.drinkDAO().getAllFavoriteDrinks())
    }
}