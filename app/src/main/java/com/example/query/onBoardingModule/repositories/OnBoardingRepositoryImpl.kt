package com.example.query.onBoardingModule.repositories

import android.content.Context
import com.example.query.onBoardingModule.models.UserModel
import com.example.query.utility.UiState
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.postgrest.postgrest
import jakarta.inject.Inject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import io.github.jan.supabase.gotrue.providers.emailProvider
import kotlinx.coroutines.withContext

class OnBoardingRepositoryImpl @Inject constructor(
    private val supabaseClient: SupabaseClient
) : OnBoardingRepository {

    override fun register(
        context: Context,
        email: String,
        password: String,
        userModel: UserModel,
        result: (UiState<String>) -> Unit
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                withContext(Dispatchers.Main) { result.invoke(UiState.Loading) }

                // 1. Sign up with email provider
                val signUpResult = supabaseClient.auth.signUpWith(emailProvider) {
                    this.email = email
                    this.password = password
                }

                val userId = signUpResult.user?.id ?: throw Exception("User ID is null")
                userModel.uid = userId

                // 2. Insert user into 'users' table
                supabaseClient.postgrest["users"].insert(userModel)

                // 3. Success
                withContext(Dispatchers.Main) {
                    result.invoke(UiState.Success("User registered successfully"))
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    result.invoke(UiState.Failure(e.localizedMessage ?: "Registration failed"))
                }
            }
        }
    }}


