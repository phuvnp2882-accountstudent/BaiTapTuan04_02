package com.example.baitaptuan04_02

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun ForgetPasswordScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }

    val backStackEntry by navController.currentBackStackEntryAsState()
    val savedStateHandle = backStackEntry?.savedStateHandle

    val confirmedEmail = savedStateHandle?.getStateFlow("confirmed_email", "")?.collectAsState("")?.value
    val confirmedCode = savedStateHandle?.getStateFlow("confirmed_code", "")?.collectAsState("")?.value
    val confirmedPassword = savedStateHandle?.getStateFlow("confirmed_password", "")?.collectAsState("")?.value

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderUTH()
        Text("Forget Password?", style = MaterialTheme.typography.titleMedium)
        Text("Enter your Email, we will send you a verification code.")
        Spacer(Modifier.height(12.dp))
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Your Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
        Button(
            onClick = {
                if (email.isNotBlank()) navController.navigate("verify/$email")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Next")
        }

        // Phần hiển thị thông tin xác nhận
        if (!confirmedEmail.isNullOrEmpty()) {
            Spacer(Modifier.height(40.dp))
            Divider()
            Text("✅ Xác nhận thành công!", style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(8.dp))
            Text("Email: $confirmedEmail")
            Text("Code: $confirmedCode")
            Text("Password: $confirmedPassword")
        }
    }
}
