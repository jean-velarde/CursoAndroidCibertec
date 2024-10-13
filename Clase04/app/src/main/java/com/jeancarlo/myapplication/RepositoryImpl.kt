package com.jeancarlo.myapplication

import android.util.Log
import com.jeancarlo.myapplication.model.ListaTodo
import io.ktor.client.call.body
import io.ktor.client.request.get

class RepositoryImpl: Repository {
    override suspend fun getTodoNotes(): List<ListaTodo> {
        try {
            val response = Factory.client.get("https://jsonplaceholder.typicode.com/todos")
            return response.body<List<ListaTodo>>().toList()
        }catch (e: Exception){
            Log.e("Error RepositoryImpl","El error es: ${e.message}")
            return listOf()
        }
    }
}