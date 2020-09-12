package com.konztic.tragosapp.domain

import com.konztic.tragosapp.data.model.Drink
import com.konztic.tragosapp.data.model.DrinkEntity
import com.konztic.tragosapp.vo.Resource

class RepoImpl(private val dataSource: DataSource): Repo {

    override suspend fun getDrinkList(drinkName: String): Resource<List<Drink>> {
        return dataSource.getDrinkByName(drinkName)
    }

    override suspend fun addFavoriteDrink(drink: DrinkEntity) {
        dataSource.insertDrinkRoom(drink)
    }

    override suspend fun getFavoriteDrinks(): Resource<List<DrinkEntity>> {
        return dataSource.getFavoriteDrinks()
    }

    override suspend fun deleteFavorite(drink: DrinkEntity) {
        return dataSource.deleteDrinkRoom(drink)
    }
}