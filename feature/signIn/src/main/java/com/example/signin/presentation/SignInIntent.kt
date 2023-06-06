package com.example.signin.presentation

sealed class SignInIntent {
    object ConfirmSignIn : SignInIntent()
    class ChangeUserEmail(val str: String) : SignInIntent()
    class ChangeUserPassword(val str: String) : SignInIntent()
}