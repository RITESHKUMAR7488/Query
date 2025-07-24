package com.example.query.utility

import androidx.appcompat.app.AppCompatActivity
import com.example.lostandfound.utility.MotionToastUtil
import jakarta.inject.Inject

class BaseActivity:AppCompatActivity(){
    @Inject
    lateinit var preferenceManager: PreferenceManager

    @Inject
    lateinit var  motionToastUtil: MotionToastUtil
}