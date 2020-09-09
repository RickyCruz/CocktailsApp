package com.konztic.tragosapp.domain

import com.konztic.tragosapp.data.DataSource
import com.konztic.tragosapp.data.model.Drink
import com.konztic.tragosapp.vo.Resource

class RepoImpl(private val dataSource: DataSource): Repo {

    override fun getDrinkList(): Resource<List<Drink>> {
        return dataSource.generateDrinkList
    }
}