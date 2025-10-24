package com.example.baitaptuan04_02

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun VerifyCodeScreen(navController: NavController, email: String) {
    var code by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderUTH(showBack = true, onBackClick = { navController.popBackStack() })
        Text("Verify Code", style = MaterialTheme.typography.titleMedium)
        Text("Enter the code sent to: $email")
        Spacer(Modifier.height(12.dp))
        OutlinedTextField(
            value = code,
            onValueChange = { code = it },
            label = { Text("Verification Code") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = { if (code.isNotBlank()) navController.navigate("newpass/$email/$code") },
            modifier = Modifier.fillMaxWidth()
        ) { Text("Next") }
    }
}
