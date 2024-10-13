package com.jeancarlo.myapplication

import com.jeancarlo.myapplication.model.ListaTodo
import com.jeancarlo.myapplication.model.RickAndMorthyRspn

interface Repository {
    suspend fun getTodoNotes(): List<ListaTodo>
    suspend fun getRickAndMorthy(): RickAndMorthyRspn
}