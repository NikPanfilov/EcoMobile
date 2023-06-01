package com.startup.ecoapp

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
	val navController = rememberNavController()
	NavHost(navController = navController, startDestination = HomeScreen.route) {
		composable(Screen.HomeScreen.route) {
			HomeScreen(navController = navController)
		}

		composable(Screen.PostScreen.route) {
			PostScreen(navController = navController)
		}

	}
}