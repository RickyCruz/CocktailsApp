package com.konztic.tragosapp.domain

import com.konztic.tragosapp.data.model.Drink
import com.konztic.tragosapp.data.model.DrinkList
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("search.php?s=")
    suspend fun getDrinkByName(@Query("drinkName") drinkName: String): DrinkList
}