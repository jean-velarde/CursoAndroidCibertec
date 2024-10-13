package com.jeancarlo.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.jeancarlo.myapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val service: RepositoryImpl = RepositoryImpl()
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
       /* CoroutineScope(Dispatchers.IO).launch {
            val lstTodo = service.getTodoNotes()
            for(data in lstTodo){
                Log.w("Response service","data id: ${data.id} - message: ${data.title}")
            }
        }*/

        binding.rv.layoutManager = LinearLayoutManager(this)

        CoroutineScope(Dispatchers.IO).launch {
            val lstRickAndMorthy = service.getRickAndMorthy()
            for(data in lstRickAndMorthy.results){
                Log.w("Response service","data id: ${data.id} - Nombre: ${data.name} - Imagen: ${data.image}")
            }
            withContext(Dispatchers.Main){
                binding.rv.adapter = RickAdapter(lstRickAndMorthy.results)
            }
        }

    }
}