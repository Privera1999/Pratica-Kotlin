package com.pmydm.practica04

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavegacionApp(){
    val navController=rememberNavController()
    NavHost(navController=navController,startDestination=AppScreens.HomePantalla.route){

        composable(route=AppScreens.HomePantalla.route){
            PrimeraPantalla(navController)
        }

        composable(route=AppScreens.FavPantalla.route){
            Favorito(navController)
        }
    }
}