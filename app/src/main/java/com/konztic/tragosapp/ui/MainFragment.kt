package com.konztic.tragosapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.konztic.tragosapp.AppDatabase
import com.konztic.tragosapp.R
import com.konztic.tragosapp.data.DataSource
import com.konztic.tragosapp.data.model.Drink
import com.konztic.tragosapp.domain.RepoImpl
import com.konztic.tragosapp.ui.adapters.DrinkAdapter
import com.konztic.tragosapp.ui.viewmodel.MainViewModel
import com.konztic.tragosapp.ui.viewmodel.VMFactory
import com.konztic.tragosapp.vo.Resource
import kotlinx.android.synthetic.main.fragment_cocktail_detail.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), DrinkAdapter.OnDrinkClickListener {

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
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecyclerView()
        setUpSearchView()
        setUpObservers()
        btn_save_or_delete_drink.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_favoritesFragment)
        }
    }

    private fun setUpObservers() {
        viewModel.fetchDrinksList.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Loading -> {
                    progress_bar.visibility = View.VISIBLE
                }
                is Resource.Success -> {
                    progress_bar.visibility = View.GONE
                    rv_drinks.adapter = DrinkAdapter(requireContext(), response.data, this)
                }
                is Resource.Failure -> {
                    progress_bar.visibility = View.GONE
                    Toast.makeText(requireContext(), "Something is wrong! ${ response.exception }", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun setUpSearchView() {
        search_view.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                viewModel.setDrink(query!!)

                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    private fun setUpRecyclerView() {
        rv_drinks.layoutManager = LinearLayoutManager(requireContext())
        rv_drinks.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
    }

    override fun onDrinkClick(drink: Drink, position: Int) {
        val bundle = Bundle()
        bundle.putParcelable("drink", drink)

        findNavController().navigate(R.id.action_mainFragment_to_detailCocktailFragment, bundle)
    }

}