package com.jeancarlo.myapplication

import android.content.Context
import android.widget.Toast

class Utils {
    companion object{
        fun showToast(context: Context ,msn: String){
            Toast.makeText(context,msn,Toast.LENGTH_LONG).show()
        }
    }
}