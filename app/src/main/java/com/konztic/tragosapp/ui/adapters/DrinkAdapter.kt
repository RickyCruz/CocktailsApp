package com.konztic.tragosapp.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.konztic.tragosapp.R
import com.konztic.tragosapp.base.BaseViewHolder
import com.konztic.tragosapp.data.model.Drink
import kotlinx.android.synthetic.main.drink_row.view.*

class DrinkAdapter(
    private val context: Context,
    private val drinksList: MutableList<Drink>,
    private val itemClickListener: OnDrinkClickListener
): RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnDrinkClickListener {
        fun onDrinkClick(drink: Drink, position: Int)
    }

    fun deleteDrink(position: Int){
        drinksList.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return DrinkMainViewHolder(
            LayoutInflater.from(context).inflate(R.layout.drink_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return drinksList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is DrinkMainViewHolder -> holder.bind(drinksList[position], position)
        }
    }

    inner class DrinkMainViewHolder(itemView: View): BaseViewHolder<Drink>(itemView) {
        override fun bind(item: Drink, position: Int) {
            Glide.with(context).load(item.image).centerCrop().into(itemView.iv_image)
            itemView.tv_name.text = item.name
            itemView.tv_description.text = item.description

            itemView.setOnClickListener {
                itemClickListener.onDrinkClick(item, position)
            }
        }
    }
}