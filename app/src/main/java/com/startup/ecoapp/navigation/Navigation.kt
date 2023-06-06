package com.startup.ecoapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.startup.ecoapp.feature.home.ui.HomeScreen
import com.startup.ecoapp.feature.post.ui.PostScreen
import com.startup.ecoapp.navigation.Screen
import ui.SignUpScreen

@Composable
fun Navigation() {
	val navController = rememberNavController()
	NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
		composable(Screen.HomeScreen.route) {
			HomeScreen(navController = navController)
		}

		composable(Screen.PostScreen.route) {
			PostScreen(navController = navController)
		}

		composable(Screen.SignUpScreen.route) {
			SignUpScreen(navController = navController)
		}

	}
}