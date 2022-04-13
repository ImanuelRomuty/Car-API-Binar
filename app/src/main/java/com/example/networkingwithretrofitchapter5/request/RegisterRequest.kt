package com.example.networkingwithretrofitchapter5.request

data class RegisterRequest(
    val email : String,
    val password : String,
    val role : String? = "admin"
)
