package com.startup.ecoapp.domain.models

data class UserSignUpData(
    val firstName:String,
    val lastName:String,
    val birthDate:String,
    val city:String,
    val phone:String,
    val email:String,
    val password:String,
    val confirmPassword:String,
)
