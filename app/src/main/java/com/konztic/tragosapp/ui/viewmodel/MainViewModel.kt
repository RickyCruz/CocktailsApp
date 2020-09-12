package com.konztic.tragosapp.ui.viewmodel

import androidx.lifecycle.*
import com.konztic.tragosapp.data.model.DrinkEntity
import com.konztic.tragosapp.domain.Repo
import com.konztic.tragosapp.vo.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel(private val repo: Repo): ViewModel() {
    private val drinksData = MutableLiveData<String>()

    fun setDrink(drinkName: String) {
        drinksData.value = drinkName
    }

    init {
        setDrink("margarita")
    }

    val fetchDrinksList = drinksData.distinctUntilChanged().switchMap { drinkName ->
        liveData(Dispatchers.IO) {
            emit(Resource.Loading())

            try {
                emit(repo.getDrinkList(drinkName))
            } catch (e: Exception) {
                emit(Resource.Failure(e))
            }
        }
    }

    fun addFavorite(drink: DrinkEntity) {
        viewModelScope.launch {
            repo.addFavoriteDrink(drink)
        }
    }

    fun getFavoriteDrinks() = liveData(Dispatchers.IO) {
        emit(Resource.Loading())

        try {
            emit(repo.getFavoriteDrinks())
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }
}