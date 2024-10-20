package com.jeancarlo.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jeancarlo.myapplication.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRoom : AppCompatActivity() {
    private lateinit var database: UserDatabase
    private lateinit var userDao: UserDAO
    private var userData: User? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user_room)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        database = UserDatabase.getDatabase(this)
        userDao = database.userDao()
        val userTest = User(name = "jean", correo = "jean@jean.com")
        createUser(userTest)

    }
    fun createUser(user: User){
        CoroutineScope(Dispatchers.IO).launch {
            userDao.insert(user)
        }
    }
}