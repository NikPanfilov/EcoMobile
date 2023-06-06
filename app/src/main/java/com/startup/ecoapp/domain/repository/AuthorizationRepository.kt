package com.startup.ecoapp.domain.repository

import com.startup.ecoapp.domain.models.UserSignInData
import com.startup.ecoapp.domain.models.UserSignUpData

interface AuthorizationRepository {
    fun signIn(userData: UserSignInData):Boolean
    fun signUp(userData: UserSignUpData):Boolean
}