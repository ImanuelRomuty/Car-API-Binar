package com.example.networkingwithretrofitchapter5.model


import com.google.gson.annotations.SerializedName

data class AdminLoginResponse(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("password")
    val password: String,
    @SerializedName("role")
    val role: Any,
    @SerializedName("updatedAt")
    val updatedAt: String
)