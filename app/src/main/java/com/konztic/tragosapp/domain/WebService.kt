package com.konztic.tragosapp.domain

import com.konztic.tragosapp.data.model.DrinkList
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("search.php")
    suspend fun getDrinkByName(@Query(value = "s") drinkName: String): DrinkList
}