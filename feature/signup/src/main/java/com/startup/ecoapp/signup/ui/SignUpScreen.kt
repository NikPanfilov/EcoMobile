package com.startup.ecoapp.signup.ui

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
import com.startup.ecoapp.signup.presentation.SignUpIntent
import com.startup.ecoapp.signup.presentation.SignUpState
import com.startup.ecoapp.signup.presentation.SignUpViewModel

@Composable
fun SignUpScreen(navController: NavController, signInViewModel: SignUpViewModel = viewModel()) {

	val state by signInViewModel.uiState.collectAsState(SignUpState())

	Column(
		horizontalAlignment = Alignment.CenterHorizontally,
		verticalArrangement = Arrangement.spacedBy(20.dp),
		modifier =
		Modifier
			.background(Color.White)
			.fillMaxSize()
			.padding(start = 40.dp, end = 40.dp, top = 20.dp)
			.verticalScroll(rememberScrollState())
	) {
		Text(
			"Sign Up",
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
					value = state.firstName,
					onValueChange = { signInViewModel.handle(SignUpIntent.ChangeUserFirstName(it)) },
					label = {
						Text(
							"First name",
							color = MaterialTheme.colorScheme.primary
						)
					}
				)
				OutlinedTextField(
					value = state.lastName,
					onValueChange = { signInViewModel.handle(SignUpIntent.ChangeUserLastName(it)) },
					label = {
						Text(
							"Last name",
							color = MaterialTheme.colorScheme.primary
						)
					}
				)
				OutlinedTextField(
					value = state.birthDate,
					onValueChange = { signInViewModel.handle(SignUpIntent.ChangeUserBirthDate(it)) },
					label = {
						Text(
							"Birth date",
							color = MaterialTheme.colorScheme.primary
						)
					}
				)
				OutlinedTextField(
					value = state.city,
					onValueChange = { signInViewModel.handle(SignUpIntent.ChangeUserCity(it)) },
					label = {
						Text(
							"City",
							color = MaterialTheme.colorScheme.primary
						)
					}
				)
				OutlinedTextField(
					value = state.phone,
					onValueChange = { signInViewModel.handle(SignUpIntent.ChangeUserPhone(it)) },
					label = {
						Text(
							"Phone",
							color = MaterialTheme.colorScheme.primary
						)
					}
				)
				OutlinedTextField(
					value = state.email,
					onValueChange = { signInViewModel.handle(SignUpIntent.ChangeUserEmail(it)) },
					label = {
						Text(
							"Email",
							color = MaterialTheme.colorScheme.primary
						)
					}
				)
				OutlinedTextField(
					value = state.password,
					onValueChange = { signInViewModel.handle(SignUpIntent.ChangeUserPassword(it)) },
					label = {
						Text(
							"Password",
							color = MaterialTheme.colorScheme.primary
						)
					}
				)
				OutlinedTextField(
					value = "",
					onValueChange = { },
					label = {
						Text(
							"Confirm password",
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
			"Have an account?", modifier = Modifier
				.clickable {
					navController.navigate("signIn_screen")
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
