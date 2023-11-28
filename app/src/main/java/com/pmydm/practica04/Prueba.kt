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

    var ListaFav = mutableListOf(
        R.drawable.coche1 to R.string.HuyundaiNombre

    )

fun hola( @DrawableRes drawable: Int){


    if (drawable==2130968597) ListaFav.add(R.drawable.coche2 to R.string.KiaNombre)
    else if (drawable==2130968598) ListaFav.add(R.drawable.coche3 to R.string.PorscheNombre)
    else if (drawable==2130968599) ListaFav.add(R.drawable.coche4 to R.string.lamborghiniNombre)
    else if (drawable==2130968600) ListaFav.add(R.drawable.coche5 to R.string.BmwNombre)

}



