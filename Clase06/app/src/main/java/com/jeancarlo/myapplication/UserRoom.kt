package com.jeancarlo.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.jeancarlo.myapplication.databinding.ActivityUserRoomBinding
import com.jeancarlo.myapplication.model.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserRoom : AppCompatActivity() {
    private lateinit var database: UserDatabase
    private lateinit var userDao: UserDAO
    private var userData: User? = null
    private  lateinit var binding: ActivityUserRoomBinding
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityUserRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        database = UserDatabase.getDatabase(this)
        userDao = database.userDao()
        binding.rv.layoutManager = LinearLayoutManager(this)
        adapter = UserAdapter(emptyList(), { userSelect ->
            binding.etUserName.setText(userSelect.name)
            binding.etUserEmail.setText(userSelect.correo)
            userData = userSelect
        }) {
            deleteUser(it)
        }

        binding.rv.adapter = adapter

        binding.btnAdd.setOnClickListener {
            if(userData != null){
                userData.let {
                    it?.name = binding.etUserName.text.toString()
                    it?.correo = binding.etUserEmail.text.toString()
                }
                updateUser(userData)
            }else{
                val userTest = User(name = binding.etUserName.text.toString(), correo = binding.etUserEmail.text.toString())
                createUser(userTest)
            }
        }


        updateDate()
    }
    fun createUser(user: User){
        CoroutineScope(Dispatchers.IO).launch {
            userDao.insert(user)
            updateDate()
        }
    }

    fun updateUser(user: User?){
        CoroutineScope(Dispatchers.IO).launch {
            user?.let{
                userDao.update(it)
            }
            updateDate()
            userData = null
        }
    }

    fun updateDate(){
        CoroutineScope(Dispatchers.IO).launch {
            val users = userDao.getAllUser()
            withContext(Dispatchers.Main){
                adapter.updateUsers(users)
            }
        }
    }

    fun deleteUser(user: User){
        CoroutineScope(Dispatchers.IO).launch {
            userDao.delete(user)
            updateDate()
        }
    }
}