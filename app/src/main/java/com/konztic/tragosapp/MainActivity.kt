package com.konztic.tragosapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.konztic.tragosapp.data.DataSource
import com.konztic.tragosapp.domain.RepoImpl
import com.konztic.tragosapp.ui.viewmodel.MainViewModel
import com.konztic.tragosapp.ui.viewmodel.VMFactory

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    private val viewModel by viewModels<MainViewModel> {
        VMFactory(RepoImpl(DataSource()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}