package com.example.baitaptuan04_02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.baitaptuan04_02.ui.theme.BaiTapTuan04_02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaiTapTuan04_02Theme {
                val navController = rememberNavController()
                NavGraph(navController)
            }
        }
    }
}
