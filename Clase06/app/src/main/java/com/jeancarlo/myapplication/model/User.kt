package com.jeancarlo.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    var name: String,
    var correo: String
)