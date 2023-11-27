package com.pmydm.practica04

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier


fun modificar(
    modifier: Modifier = Modifier,
    @DrawableRes drawable: Int


) {
    if (drawable==2130968605){
        categoria.value= 1
    }



}

private fun <T> MutableState<T>.setValue(thisObj: T) {

}
