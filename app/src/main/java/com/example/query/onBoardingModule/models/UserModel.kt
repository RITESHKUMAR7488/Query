package com.example.query.onBoardingModule.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserModel(
    var uid: String? = null,                    // Supabase Auth user ID
    var email: String? = null,                  // Email used for login
    var fullName: String? = null,              // First name of the user
    var password: String? = null,               // ⚠️ Should NOT be saved, only used for registration
    var mobileNumber: String? = null,           // Optional phone number
    var imageUrl: String? = null,               // Profile picture URL (from Supabase Storage or elsewhere)
    var isVerified: Boolean = false,            // For verification status (email/phone)
    var createdAt: Long = System.currentTimeMillis(), // Timestamp for account creation
) : Parcelable
