package com.example.networkingwithretrofitchapter5.model


import com.google.gson.annotations.SerializedName

data class RegisterResponseItem(
    @SerializedName("createdAt")
    val createdAt: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("id")
    val id: Int,
    //Password hasil enkrip makanya disembunyi
/*    @SerializedName("password")
    val password: String,*/
    @SerializedName("role")
    val role: String,
    @SerializedName("updatedAt")
    val updatedAt: String
)