package com.example.signin.ui


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.signin.presentation.SignInIntent
import com.example.signin.presentation.SignInViewModel

@Composable
fun SignUpScreen(navController: NavController, signInViewModel: SignInViewModel = viewModel()) {

    val state by signInViewModel.uiState.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(
            space = 20.dp,
            alignment = Alignment.CenterVertically,
        ),
        modifier =
        Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(start = 40.dp, end = 40.dp, top = 20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            "Sign In",
            style = MaterialTheme.typography.displaySmall,
            color = MaterialTheme.colorScheme.primary
        )
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(
                Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                OutlinedTextField(
                    value = state.email,
                    onValueChange = { signInViewModel.handle(SignInIntent.ChangeUserEmail(it)) },
                    label = {
                        Text(
                            "Email",
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                )
                OutlinedTextField(
                    value = state.password,
                    onValueChange = { signInViewModel.handle(SignInIntent.ChangeUserPassword(it)) },
                    label = {
                        Text(
                            "Password",
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                )
            }
        }
        Button(onClick = {}, Modifier.width(150.dp)) {
            androidx.compose.material3.Text("Confirm", style = MaterialTheme.typography.bodyLarge)
        }
        Text(
            "Sign Up", modifier = Modifier
                .clickable {
                    navController.navigate("signUp_screen")
                },
            style = MaterialTheme.typography.titleSmall,
            color = Color.Gray
        )
        Spacer(Modifier.height(20.dp))
    }
}

@Preview
@Composable
fun preview() {
    SignUpScreen(navController = rememberNavController())
}