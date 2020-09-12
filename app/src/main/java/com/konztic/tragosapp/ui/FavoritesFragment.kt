package com.konztic.tragosapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.konztic.tragosapp.AppDatabase
import com.konztic.tragosapp.R
import com.konztic.tragosapp.data.DataSource
import com.konztic.tragosapp.data.model.Drink
import com.konztic.tragosapp.data.model.DrinkEntity
import com.konztic.tragosapp.domain.RepoImpl
import com.konztic.tragosapp.ui.adapters.DrinkAdapter
import com.konztic.tragosapp.ui.viewmodel.MainViewModel
import com.konztic.tragosapp.ui.viewmodel.VMFactory
import com.konztic.tragosapp.vo.Resource
import kotlinx.android.synthetic.main.fragment_favorites.*
import kotlinx.android.synthetic.main.fragment_main.*

class FavoritesFragment : Fragment(), DrinkAdapter.OnDrinkClickListener {

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

        setUpRecyclerView()
        setUpObservers()
    }

    private fun setUpObservers() {
        viewModel.getFavoriteDrinks().observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Loading -> {
                }
                is Resource.Success -> {
                    val favoriteDrinks = response.data.map {
                        Drink(it.drinkId, it.image, it.name, it.description, it.hasAlcohol)
                    }

                    rv_drinks.adapter = DrinkAdapter(requireContext(), favoriteDrinks, this)
                }
                is Resource.Failure -> {
                    Toast.makeText(requireContext(), "Something is wrong! ${ response.exception }", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun setUpRecyclerView() {
        rv_favorite_drinks.layoutManager = LinearLayoutManager(requireContext())
        rv_favorite_drinks.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
    }

    override fun onDrinkClick(drink: Drink, position: Int) {
        viewModel.removeFavorite(DrinkEntity(drink.drinkId,drink.image,drink.name,drink.description,drink.hasAlcohol))
        rv_favorite_drinks.adapter?.notifyItemRemoved(position)
    }

}