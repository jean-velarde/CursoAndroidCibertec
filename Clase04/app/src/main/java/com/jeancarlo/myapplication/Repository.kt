package com.jeancarlo.myapplication

import com.jeancarlo.myapplication.model.ListaTodo

interface Repository {
    suspend fun getTodoNotes(): List<ListaTodo>
}