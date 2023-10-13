package com.example.demo

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.demo.ui.mushroom.Title
import com.example.demo.ui.mushroom.Title2
import com.example.demo.viewmodels.SecondViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceSecondViewModel: Bundle?) {
        super.onCreate(savedInstanceSecondViewModel)
        setContent {
            App(this)
        }
    }

}
@Composable
fun App(context:Context) {

    val secondViewModel = viewModel<SecondViewModel>(
        factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return SecondViewModel(
                    context = context
                ) as T
            }
        }
    )

    val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = "firstmushroom",
        )

        {
            composable("firstmushroom") {
                Title(navController,secondViewModel)
            }
            composable("secondmushroom") {
                Title2(navController,secondViewModel)
            }
            composable("secondmushroom") {
                Title2(navController,secondViewModel)
            }
            composable("firstdmushroom") {
                Title(navController, secondViewModel)
            }

        }

}