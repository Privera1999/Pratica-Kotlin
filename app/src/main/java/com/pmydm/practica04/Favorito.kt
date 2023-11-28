package com.pmydm.practica04

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.pmydm.practica04.ui.theme.Practica04Theme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Favorito(navController: NavController){
    Scaffold {


        DestacadoGridFavorito()
    }
}
@Composable
fun DestacadosFav(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier)
    {

        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(135.dp)
                .width(135.dp)
                .clip(RoundedCornerShape(8.dp))

        )


        Text(
            text= stringResource(text),
            modifier = Modifier
                .paddingFromBaseline(top = 0.dp, bottom = 8.dp)
                .align(Alignment.Start),
            style = MaterialTheme.typography.bodyMedium)
        Text(
            text= "Destacado",
            modifier = Modifier
                .paddingFromBaseline(top = 10.dp)
                .align(Alignment.Start),
            style = MaterialTheme.typography.bodySmall)

        }


    }


@Composable
fun DestacadoGridFavorito(
    modifier: Modifier = Modifier,

    ) {
    Text(
        text = "Destacados",
        modifier = Modifier
            .paddingFromBaseline(top = 5.dp, bottom = 20.dp)
            .padding(start = 16.dp),
        style = MaterialTheme.typography.titleLarge
    )


    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),

    ) {

            items(ListaFav) { item ->
                DestacadosFav(item.first, item.second)
            }

        }

    }

