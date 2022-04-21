package com.example.networkingwithretrofitchapter5.request

data class RegisterRequest(
    val email : String? = null,
    val password : String? = null,
    val role : String? = "admin"
)
