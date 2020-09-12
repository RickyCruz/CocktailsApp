package com.konztic.tragosapp.data

import com.konztic.tragosapp.AppDatabase
import com.konztic.tragosapp.data.model.Drink
import com.konztic.tragosapp.data.model.DrinkEntity
import com.konztic.tragosapp.domain.DataSource
import com.konztic.tragosapp.vo.Resource
import com.konztic.tragosapp.vo.RetrofitClient

class DataSourceImpl(private val appDatabase: AppDatabase): DataSource {

    override suspend fun getDrinkByName(name: String): Resource<List<Drink>> {
        return Resource.Success(
            RetrofitClient.webservice.getDrinkByName(name).drinkList
        )
    }

    override suspend fun insertDrinkRoom(drink: DrinkEntity) {
        appDatabase.drinkDAO().addFavorite(drink)
    }

    override suspend fun deleteDrinkRoom(drink: DrinkEntity) {
        appDatabase.drinkDAO().deleteFavorite(drink)
    }

    override suspend fun getFavoriteDrinks(): Resource<List<DrinkEntity>> {
        return Resource.Success(appDatabase.drinkDAO().getAllFavoriteDrinks())
    }
}