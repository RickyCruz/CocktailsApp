package com.konztic.tragosapp.domain

import com.konztic.tragosapp.data.model.Drink
import com.konztic.tragosapp.vo.Resource

interface Repo {
    fun getDrinkList(): Resource<List<Drink>>
}