package com.konztic.tragosapp.domain

import com.konztic.tragosapp.data.model.Drink
import com.konztic.tragosapp.vo.Resource

interface Repo {
    suspend fun getDrinkList(drinkName: String): Resource<List<Drink>>
}