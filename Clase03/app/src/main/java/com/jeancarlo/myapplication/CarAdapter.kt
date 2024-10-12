package com.jeancarlo.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarAdapter(val cars: List<Car>): RecyclerView.Adapter<CarAdapter.CarViewHolder>() {
    class CarViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val carName: TextView = itemView.findViewById(R.id.txtItemCarNombre)
        val carBrand: TextView = itemView.findViewById(R.id.txtBrand)
        val carYear: TextView = itemView.findViewById(R.id.txtYear)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false)
        return CarViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cars.size
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
        val car = cars[position]
        holder.carName.text = car.name
        holder.carBrand.text = car.brand
        holder.carYear.text = car.year.toString()
    }
}