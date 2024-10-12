package com.jeancarlo.myapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jeancarlo.myapplication.databinding.ActivityListViewExampleBinding

class ListViewExample : AppCompatActivity() {

    private lateinit var binding: ActivityListViewExampleBinding
    val lstNumber = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityListViewExampleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        for (i in 1..50){
            lstNumber.add("Puesto - $i")
        }
        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, lstNumber)
        binding.lstView.adapter = adapter

        binding.lstView.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(this,"${lstNumber[position]}", Toast.LENGTH_SHORT).show()
        }
        binding.btnAgregar.setOnClickListener {
            lstNumber.add("Puesto - ${lstNumber.count()+1}")
            adapter.notifyDataSetChanged()
        }
    }
}