package com.konztic.tragosapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.konztic.tragosapp.domain.Repo
import com.konztic.tragosapp.vo.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class MainViewModel(private val repo: Repo): ViewModel() {
    val fetchDrinksList = liveData(Dispatchers.IO) {
        emit(Resource.Loading())

        try {
            emit(repo.getDrinkList("margarita"))
        } catch (e: Exception) {
            emit(Resource.Failure(e))
        }
    }
}