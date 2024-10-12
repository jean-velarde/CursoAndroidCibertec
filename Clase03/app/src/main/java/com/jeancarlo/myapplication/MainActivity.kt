package com.jeancarlo.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jeancarlo.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    var flagVisible = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnListView.setOnClickListener {
            val intent = Intent(this, ListViewExample::class.java)
            startActivity(intent)
        }

        binding.btnRv.setOnClickListener {
            val intent = Intent(this, RecycleViewExample::class.java)
            startActivity(intent)
        }
        binding.btOcultar.setOnClickListener {
            if(!flagVisible) {
                binding.btnRv.visibility = View.GONE
                flagVisible = true
            }
            else {
                binding.btnRv.visibility = View.VISIBLE
                flagVisible = false
            }
        }
    }
}