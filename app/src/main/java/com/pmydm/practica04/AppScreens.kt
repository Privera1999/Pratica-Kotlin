package com.pmydm.practica04

sealed class AppScreens(val route:String) {
    object HomePantalla: AppScreens("PrimeraPantalla")
    object FavPantalla: AppScreens("Favorito")

}