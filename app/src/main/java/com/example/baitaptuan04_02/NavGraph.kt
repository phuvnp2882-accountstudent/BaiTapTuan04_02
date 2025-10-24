package com.example.baitaptuan04_02

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.NavHostController

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "forget") {
        composable("forget") { ForgetPasswordScreen(navController) }

        composable(
            route = "verify/{email}",
            arguments = listOf(navArgument("email") { type = NavType.StringType })
        ) {
            val email = it.arguments?.getString("email") ?: ""
            VerifyCodeScreen(navController, email)
        }

        composable(
            route = "newpass/{email}/{code}",
            arguments = listOf(
                navArgument("email") { type = NavType.StringType },
                navArgument("code") { type = NavType.StringType }
            )
        ) {
            val email = it.arguments?.getString("email") ?: ""
            val code = it.arguments?.getString("code") ?: ""
            NewPasswordScreen(navController, email, code)
        }

        composable(
            route = "confirm/{email}/{code}/{password}",
            arguments = listOf(
                navArgument("email") { type = NavType.StringType },
                navArgument("code") { type = NavType.StringType },
                navArgument("password") { type = NavType.StringType }
            )
        ) {
            val email = it.arguments?.getString("email") ?: ""
            val code = it.arguments?.getString("code") ?: ""
            val password = it.arguments?.getString("password") ?: ""
            ConfirmScreen(navController, email, code, password)
        }
    }
}
