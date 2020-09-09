package com.konztic.tragosapp.data

import com.konztic.tragosapp.data.model.Drink
import com.konztic.tragosapp.vo.Resource
import com.konztic.tragosapp.vo.RetrofitClient

class DataSource {

    suspend fun getDrinkByName(name: String): Resource<List<Drink>> {
        return Resource.Success(
            RetrofitClient.webservice.getDrinkByName(name).drinkList
        )
    }
}