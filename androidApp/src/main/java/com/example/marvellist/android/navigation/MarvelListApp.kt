package com.example.marvellist.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.marvellist.android.ui.detailscharacter.DetailsCharacterScreen
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
        composable(route = makeRoute(Route.HOME_SCREEN)){
            HomeScreen(){
                navController.navigate(Route.CHARACTER_LIST_SCREEN.name)
            }
        }
        composable(route = makeRoute(Route.CHARACTER_LIST_SCREEN)) {
            ListCharacterScreen(){
                navController.navigate("${Route.CHARACTER_DETAILS}/${it}")
            }
        }
        composable(route = "CHARACTER_DETAILS/{id}") {
            val id = it.arguments?.getString("id") ?: "0"
            DetailsCharacterScreen(id)
        }
    }
}


//TODO put this inside Route class
private fun makeRoute(route: Route): String{
    route.argument?.let {
        return "${route.value}${route.argument}=${route.argument}"
    }
    return route.value
}