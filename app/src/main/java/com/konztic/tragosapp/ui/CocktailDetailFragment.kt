package com.konztic.tragosapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.konztic.tragosapp.R
import com.konztic.tragosapp.data.model.Drink
import com.konztic.tragosapp.data.model.DrinkEntity
import com.konztic.tragosapp.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_cocktail_detail.*

@AndroidEntryPoint
class DetailCocktailFragment : Fragment() {

    private val viewModel by activityViewModels<MainViewModel>()

    private lateinit var drink: Drink

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireArguments().let {
            drink = it.getParcelable<Drink>("drink")!!
            // Log.d("D_FRAG ", "$drink")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cocktail_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(requireContext()).load(drink.image).centerCrop().into(img_drink)

        drink_title.text = drink.name
        drink_desc.text = drink.description

        if (drink.hasAlcohol == "Non_Alcoholic") {
            drink_has_alcohol.text = "Alcohol Free"
        } else {
            drink_has_alcohol.text = "With Alcohol"
        }

        btn_save_or_delete_drink.setOnClickListener {
            viewModel.addFavorite(
               DrinkEntity(drink.drinkId, drink.image, drink.name, drink.description, drink.hasAlcohol)
            )

            Toast.makeText(requireContext(), "Drink ${ drink.name } saved as favorite", Toast.LENGTH_SHORT).show()
        }
    }

}