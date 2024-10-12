package com.jeancarlo.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.jeancarlo.myapplication.databinding.ActivityRecycleViewExampleBinding

class RecycleViewExample : AppCompatActivity() {
    private lateinit var binding: ActivityRecycleViewExampleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRecycleViewExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val cars = mutableListOf<Car>(
            Car("Modelo A","Brand A", 2000),
            Car("Modelo B","Brand B", 2001),
            Car("Modelo C","Brand C", 2002),
            Car("Modelo D","Brand D", 2003),
            Car("Modelo E","Brand E", 2004),
            Car("Modelo F","Brand F", 2005),
            Car("Modelo G","Brand G", 2006),
            Car("Modelo H","Brand H", 2007),
            Car("Modelo A","Brand A", 2000),
            Car("Modelo B","Brand B", 2001),
            Car("Modelo C","Brand C", 2002),
            Car("Modelo D","Brand D", 2003),
            Car("Modelo E","Brand E", 2004),
            Car("Modelo F","Brand F", 2005),
            Car("Modelo G","Brand G", 2006),
            Car("Modelo H","Brand H", 2007),
        )
        binding.rv.layoutManager = LinearLayoutManager(this)
        //binding.rv.adapter = CarAdapter(cars)
        binding.rv.adapter = CarAdapterWithBinding(cars)
    }
}