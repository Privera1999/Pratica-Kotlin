package com.pmydm.practica04

import androidx.annotation.DrawableRes
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier


fun modificar(
    modifier: Modifier = Modifier,
    @DrawableRes drawable: Int


) {
    if (drawable==2130968605){
        categoria.value= 1
    }
    else if (drawable==2130968602){
        categoria.value=0
    }


}

private fun <T> MutableState<T>.setValue(thisObj: T) {

}

data class Favoritosclass(
    val imagenResId: Int,
    val nombreResId: Int,
    val precioResId: Int
)

    var ListaFav = mutableListOf(
        Favoritosclass (R.drawable.coche1, R.string.HuyundaiNombre , R.string.HyundaiPrecio)

    )

fun DarFav(@DrawableRes drawable: Int){

    if (drawable==2130968597) ListaFav.add(Favoritosclass( R.drawable.coche2 , R.string.KiaNombre , R.string.HyundaiPrecio))
    else if (drawable==2130968598) ListaFav.add(Favoritosclass(R.drawable.coche3 , R.string.PorscheNombre , R.string.PorschePrecio))
    else if (drawable==2130968599) ListaFav.add(Favoritosclass(R.drawable.coche4 , R.string.lamborghiniNombre , R.string.lamborghiniPrecio))
    else if (drawable==2130968600) ListaFav.add(Favoritosclass(R.drawable.coche5 , R.string.BmwNombre , R.string.BmwPrecio))
    else if (drawable==2130968596) ListaFav.add(Favoritosclass(R.drawable.coche1 , R.string.HuyundaiNombre ,  R.string.HyundaiPrecio))
    else if (drawable==2130968607) ListaFav.add(Favoritosclass(R.drawable.moto1 , R.string.Moto1 ,  R.string.Moto1Precio))
    else if (drawable==2130968608) ListaFav.add(Favoritosclass(R.drawable.moto2 , R.string.Moto2 ,  R.string.Moto2Precio))
    else if (drawable==2130968609) ListaFav.add(Favoritosclass(R.drawable.moto3 , R.string.Moto3 ,  R.string.Moto3Precio))
    else if (drawable==2130968610) ListaFav.add(Favoritosclass(R.drawable.moto4 , R.string.Moto4 ,  R.string.Moto4Precio))
    else if (drawable==2130968611) ListaFav.add(Favoritosclass(R.drawable.moto5 , R.string.Moto5 ,  R.string.Moto5Precio))

}

fun QuitarFav(@DrawableRes drawable: Int){

    if (drawable==2130968597) ListaFav.remove(element = Favoritosclass(R.drawable.coche2 , R.string.KiaNombre , R.string.HyundaiPrecio))
    else if (drawable==2130968598) ListaFav.remove(element = Favoritosclass(R.drawable.coche3 , R.string.PorscheNombre , R.string.PorschePrecio))
    else if (drawable==2130968599) ListaFav.remove(element = Favoritosclass(R.drawable.coche4 , R.string.lamborghiniNombre , R.string.lamborghiniPrecio))
    else if (drawable==2130968600) ListaFav.remove(element = Favoritosclass(R.drawable.coche5 , R.string.BmwNombre , R.string.BmwPrecio))
    else if (drawable==2130968596) ListaFav.remove(element = Favoritosclass(R.drawable.coche1 , R.string.HuyundaiNombre ,  R.string.HyundaiPrecio))
    else if (drawable==2130968607) ListaFav.remove(element = Favoritosclass(R.drawable.moto1 , R.string.Moto1 ,  R.string.Moto1Precio))
    else if (drawable==2130968608) ListaFav.remove(element = Favoritosclass(R.drawable.moto2 , R.string.Moto2 ,  R.string.Moto2Precio))
    else if (drawable==2130968609) ListaFav.remove(element = Favoritosclass(R.drawable.moto3 , R.string.Moto3 ,  R.string.Moto3Precio))
    else if (drawable==2130968610) ListaFav.remove(element = Favoritosclass(R.drawable.moto4 , R.string.Moto4 ,  R.string.Moto4Precio))
    else if (drawable==2130968611) ListaFav.remove(element = Favoritosclass(R.drawable.moto5 , R.string.Moto5 ,  R.string.Moto5Precio))


}



