package com.example.baitaptuan04_02

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ConfirmScreen(navController: NavController, email: String, code: String, password: String) {
    var reEmail by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderUTH(showBack = true, onBackClick = { navController.popBackStack() })
        Text("Confirm", style = MaterialTheme.typography.titleMedium)
        Text("Please confirm your information below")
        Spacer(Modifier.height(12.dp))
        OutlinedTextField(
            value = reEmail,
            onValueChange = { reEmail = it },
            label = { Text("Enter Email Again") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = code,
            onValueChange = {},
            label = { Text("Verification Code") },
            modifier = Modifier.fillMaxWidth(),
            enabled = false
        )
        OutlinedTextField(
            value = password,
            onValueChange = {},
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            enabled = false
        )
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = {
                navController.navigate("forget") {
                    popUpTo("forget") { inclusive = true }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Submit") }
    }
}
