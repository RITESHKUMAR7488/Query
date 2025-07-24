package com.example.query.utility

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.qualifiers.ApplicationContext
import jakarta.inject.Inject

class PreferenceManager @Inject constructor(
    @ApplicationContext private val context:Context
) {
    private val mPreferences:SharedPreferences=context.getSharedPreferences(
        Constant.AUTH,
        AppCompatActivity.MODE_PRIVATE
    )
    private val editor:SharedPreferences.Editor=mPreferences.edit()

    var isLoggedIn:Boolean
        get() = mPreferences.getBoolean(Constant.LOGGED_IN,false)
        set(value){
            editor.putBoolean(Constant.LOGGED_IN,value).apply()
        }
}