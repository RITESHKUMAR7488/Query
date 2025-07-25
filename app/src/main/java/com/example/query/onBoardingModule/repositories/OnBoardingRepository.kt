package com.example.query.onBoardingModule.repositories

import android.content.Context
import com.example.query.onBoardingModule.models.UserModel
import com.example.query.utility.UiState

interface OnBoardingRepository {
    fun register(context: Context,email:String,password:String,userModel: UserModel,result: (UiState<String>)->Unit) }
    fun sendUserData(context: Context,userModel: UserModel,result: (UiState<String>) -> Unit) {}
