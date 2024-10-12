package com.jeancarlo.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jeancarlo.myapplication.databinding.ItemCarBinding

class CarAdapterWithBinding(val cars: List<Car>): RecyclerView.Adapter<CarAdapterWithBinding.CarBindingViewHolder>() {

    class CarBindingViewHolder(val binding: ItemCarBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarBindingViewHolder {
        val binding = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarBindingViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return cars.size
    }

    override fun onBindViewHolder(holder: CarBindingViewHolder, position: Int) {
        val car = cars[position]
        holder.binding.txtItemCarNombre.text = car.name
        holder.binding.txtBrand.text = car.brand
        holder.binding.txtYear.text = car.year.toString()
    }
}