package com.example.signin.presentation

sealed class SignUpIntent {
    object ConfirmSignIn : SignUpIntent()
    class ChangeUserFirstName(val str: String) : SignUpIntent()
    class ChangeUserLastName(val str: String) : SignUpIntent()
    class ChangeUserBirthDate(val str: String) : SignUpIntent()
    class ChangeUserEmail(val str: String) : SignUpIntent()
    class ChangeUserPassword(val str: String) : SignUpIntent()
    class ChangeUserPhone(val str: String) : SignUpIntent()
    class ChangeUserCity(val str: String) : SignUpIntent()
    class ChangeUserConfirmPassword(val str: String) : SignUpIntent()
}