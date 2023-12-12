package com.pmydm.practica04

import androidx.annotation.DrawableRes
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier


fun modificar(
    modifier: Modifier = Modifier,
    idcategoria: Int


) {
    if (idcategoria==0){
        categoria.value= 0
    }
    else if (idcategoria==1){
        categoria.value=1
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

fun DarFav(id: Int){

    if (id==1) ListaFav.add(Favoritosclass (R.drawable.coche1, R.string.HuyundaiNombre , R.string.HyundaiPrecio))
    else if (id==2) ListaFav.add(Favoritosclass( R.drawable.coche2 , R.string.KiaNombre , R.string.HyundaiPrecio))
    else if (id==3) ListaFav.add(Favoritosclass(R.drawable.coche3 , R.string.PorscheNombre , R.string.PorschePrecio))
    else if (id==4) ListaFav.add(Favoritosclass(R.drawable.coche4 , R.string.lamborghiniNombre , R.string.lamborghiniPrecio))
    else if (id==5) ListaFav.add(Favoritosclass(R.drawable.coche5 , R.string.BmwNombre , R.string.BmwPrecio))
    else if (id==6) ListaFav.add(Favoritosclass(R.drawable.moto1 , R.string.Moto1 ,  R.string.Moto1Precio))
    else if (id==7) ListaFav.add(Favoritosclass(R.drawable.moto2 , R.string.Moto2 ,  R.string.Moto2Precio))
    else if (id==8) ListaFav.add(Favoritosclass(R.drawable.moto3 , R.string.Moto3 ,  R.string.Moto3Precio))
    else if (id==9) ListaFav.add(Favoritosclass(R.drawable.moto4 , R.string.Moto4 ,  R.string.Moto4Precio))
    else if (id==10) ListaFav.add(Favoritosclass(R.drawable.moto5 , R.string.Moto5 ,  R.string.Moto5Precio))

}

fun QuitarFav(id: Int){

    if (id==1) ListaFav.remove(element = Favoritosclass(R.drawable.coche2 , R.string.KiaNombre , R.string.HyundaiPrecio))
    else if (id==2) ListaFav.remove(element = Favoritosclass(R.drawable.coche3 , R.string.PorscheNombre , R.string.PorschePrecio))
    else if (id==3) ListaFav.remove(element = Favoritosclass(R.drawable.coche4 , R.string.lamborghiniNombre , R.string.lamborghiniPrecio))
    else if (id==4) ListaFav.remove(element = Favoritosclass(R.drawable.coche5 , R.string.BmwNombre , R.string.BmwPrecio))
    else if (id==5) ListaFav.remove(element = Favoritosclass(R.drawable.coche1 , R.string.HuyundaiNombre ,  R.string.HyundaiPrecio))
    else if (id==6) ListaFav.remove(element = Favoritosclass(R.drawable.moto1 , R.string.Moto1 ,  R.string.Moto1Precio))
    else if (id==7) ListaFav.remove(element = Favoritosclass(R.drawable.moto2 , R.string.Moto2 ,  R.string.Moto2Precio))
    else if (id==8) ListaFav.remove(element = Favoritosclass(R.drawable.moto3 , R.string.Moto3 ,  R.string.Moto3Precio))
    else if (id==9) ListaFav.remove(element = Favoritosclass(R.drawable.moto4 , R.string.Moto4 ,  R.string.Moto4Precio))
    else if (id==10) ListaFav.remove(element = Favoritosclass(R.drawable.moto5 , R.string.Moto5 ,  R.string.Moto5Precio))


}



