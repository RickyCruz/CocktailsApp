package com.konztic.tragosapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.konztic.tragosapp.AppDatabase
import com.konztic.tragosapp.R
import com.konztic.tragosapp.data.DataSource
import com.konztic.tragosapp.domain.RepoImpl
import com.konztic.tragosapp.ui.viewmodel.MainViewModel
import com.konztic.tragosapp.ui.viewmodel.VMFactory
import com.konztic.tragosapp.vo.Resource

class FavoritesFragment : Fragment() {

    private val viewModel by activityViewModels<MainViewModel> {
        VMFactory(
            RepoImpl(
                DataSource(AppDatabase.getDatabase(requireActivity().applicationContext))
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getFavoriteDrinks().observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Loading -> {
                }
                is Resource.Success -> {
                    Log.d("LIST", "${ response.data }")
                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), "Something is wrong! ${ response.exception }", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

}