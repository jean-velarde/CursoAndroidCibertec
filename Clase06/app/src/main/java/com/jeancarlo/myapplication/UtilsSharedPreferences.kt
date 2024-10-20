package com.jeancarlo.myapplication

import android.content.Context
import android.content.Context.MODE_PRIVATE

class UtilsSharedPreferences {
    companion object {
        fun createSesion(context: Context){
            val sharedPref = context.getSharedPreferences("com.midominio.miaplicacion", MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putBoolean("login",true)
            editor.apply()
        }

        fun getSesion(context: Context): Boolean{
            val sharedPref = context.getSharedPreferences("com.midominio.miaplicacion", MODE_PRIVATE)
            return sharedPref.getBoolean("login",false)
        }
    }
}