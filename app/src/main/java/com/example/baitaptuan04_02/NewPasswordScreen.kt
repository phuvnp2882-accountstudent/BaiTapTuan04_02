package com.example.baitaptuan04_02

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun NewPasswordScreen(navController: NavController, email: String, code: String) {
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderUTH(showBack = true, onBackClick = { navController.popBackStack() })
        Text("Create new password", style = MaterialTheme.typography.titleMedium)
        Text("Your new password must be different from previous one.")
        Spacer(Modifier.height(12.dp))
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("New Password") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = { if (password.isNotBlank()) navController.navigate("confirm/$email/$code/$password") },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Next") }
    }
}
