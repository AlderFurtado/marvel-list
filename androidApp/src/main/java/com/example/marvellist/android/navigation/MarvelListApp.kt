package com.example.marvellist.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marvellist.android.ui.home.HomeScreen
import com.example.marvellist.android.ui.listcharacter.ListCharacterScreen

@Composable
fun MarvelListApp(
    navController: NavHostController = rememberNavController()
){
    NavHost(
        navController = navController,
        startDestination = Route.HOME_SCREEN.name
    ){
        composable(route = Route.HOME_SCREEN.name){
            HomeScreen(){
                navController.navigate(Route.CHARACTER_LIST_SCREEN.name)
            }
        }
        composable(route = Route.CHARACTER_LIST_SCREEN.name) {
            ListCharacterScreen()
        }
    }
}