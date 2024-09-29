package com.jeancarlo.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jeancarlo.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnAction.setOnClickListener {
            val textToShow = "${binding.etNombre.text}: ${binding.etEp1.text}"
            Utils.showToast(this@MainActivity,textToShow)

            var ep1: Int = binding.etEp1.text.toString().toInt()
            if(binding.rbAdd.isChecked){
                ep1 += 1
            }

            val newView = Intent(this, Destino::class.java)
            newView.putExtra("nombre","${binding.etNombre.text}")
            newView.putExtra("ep1","$ep1")
            newView.putExtra("ep2","${binding.etEp2.text}")
            startActivity(newView)
        }
    }
}