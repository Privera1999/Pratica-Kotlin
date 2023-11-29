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
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat.recreate
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.pmydm.practica04.ui.theme.Practica04Theme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Favorito(navController: NavController){
    Scaffold {

        FavoritoApp(navController)
    }
}
@Composable
fun DestacadosFav(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    @StringRes precio: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier.fillMaxWidth()
    ){

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier)
        {

            Row(modifier = modifier.align(Start)){
                Image(
                    painter = painterResource(drawable),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(135.dp)
                        .width(135.dp)
                        .clip(RoundedCornerShape(8.dp))

                )

                Spacer(modifier = Modifier.width(20.dp))

                Text(
                    text= stringResource(text),
                    modifier = Modifier
                        .paddingFromBaseline(top = 0.dp, bottom = 8.dp)
                        .align(CenterVertically),
                    fontSize = 15.sp)

                Spacer(modifier = Modifier.width(10.dp))

                Text(
                    text= stringResource(precio),
                    modifier = Modifier
                        .paddingFromBaseline(top = 0.dp, bottom = 8.dp)
                        .align(CenterVertically),
                    fontSize = 15.sp)


            }
            }




    }



    }


@Composable
fun DestacadoGridFavorito(
    modifier: Modifier = Modifier,

    ) {

    ListaFav.remove(element = Favoritosclass(R.drawable.coche1 , R.string.HuyundaiNombre ,  R.string.HyundaiPrecio))

    Column {

        Spacer(modifier = Modifier.height(15.dp))

        LazyColumn(
            modifier = modifier,
            contentPadding = PaddingValues(horizontal = 16.dp),

            ) {

            items(ListaFav) { item ->
                DestacadosFav(item.imagenResId,item.nombreResId,item.precioResId)
                Spacer(modifier = Modifier.height(15.dp))
            }

        }

    }



    }

@Composable
private fun BarraDeNavegacion(navController: NavController) {
    NavigationBar(

        containerColor = MaterialTheme.colorScheme.surfaceVariant
    )
    {
        NavigationBarItem(
            selected = false ,
            onClick = { navController.navigate(route = AppScreens.HomePantalla.route) },
            icon = { Icon(imageVector = Icons.Default.Home , contentDescription = null ) },
            label = { Text(text = stringResource(R.string.Inicio))}
        )

        NavigationBarItem(
            selected = true,
            onClick = { navController.navigate(route = AppScreens.FavPantalla.route) },
            icon = { Icon(imageVector = Icons.Default.FavoriteBorder, contentDescription = null) },
            label = { Text(text = stringResource(R.string.Favoritos))}
        )

        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.AddCircle, contentDescription = null) },
            label = { Text(text = stringResource(R.string.Subelo))}
        )

        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Email, contentDescription = null) },
            label = { Text(text = stringResource(R.string.Buzon))}
        )

        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null) },
            label = { Text(text = stringResource(R.string.Tu))}
        )

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavoritoApp(navController: NavController) {

    Practica04Theme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {Text(text = "Favoritos",
                    fontSize = 35.sp)
                            },

            )
                     
                     },

            bottomBar = { BarraDeNavegacion(navController) }
        ) {
                padding -> DestacadoGridFavorito(Modifier.padding(padding))
        }
    }


}