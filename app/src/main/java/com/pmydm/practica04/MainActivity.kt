package com.pmydm.practica04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pmydm.practica04.ui.theme.Practica04Theme




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Practica04Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {

        TextField(
            value = "",
            shape = MaterialTheme.shapes.medium,
            onValueChange = {},
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search,
                    contentDescription = null)
            },

            placeholder = {
                Text("Buscar")
            },
            modifier = modifier
                .fillMaxWidth()
        )


    }

@Composable
fun MuyBuscado(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ){
        Row(
            modifier = Modifier
                .width(180.dp)
                .height(140.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text= stringResource(text),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.weight(1f))


                Image(
                    modifier = Modifier,
                    painter = painterResource(drawable),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
        }
    }
}

@Composable
fun Categorias(
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
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .height(40.dp)
                .width(35.dp)
                .clip(CircleShape)
                .border(1.dp, Color.Black, shape = CircleShape)

        )
        Text(
            text= stringResource(text),
            modifier = Modifier.paddingFromBaseline(top = 24.dp,bottom = 8.dp),
            style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun CategoriasRow(
    modifier: Modifier = Modifier
) {
    // Implement composable here

    LazyRow(modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(40.dp)
    ){
        items(CategoriasColeccion){
                item -> Categorias(item.drawable, item.text)
        }
    }

}

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

private val muybuscadoColeccion = listOf(
    R.drawable.muybuscado to R.string.Iphone,
    R.drawable.coche to R.string.Coches,
    R.drawable.switch1 to R.string.Switch,

).map { DrawableStringPair(it.first, it.second) }

private val CategoriasColeccion = listOf(
    R.drawable.emoticonocoche to R.string.Coches,
    R.drawable.emoticonomoto to R.string.Motos,
    R.drawable.emoticonocasco to R.string.Accesorios,
    R.drawable.emoticonoropa to R.string.Ropa,
    R.drawable.emoticonolibro to R.string.Libro,
    R.drawable.emoticonoconsola to R.string.Consola,


    ).map { DrawableStringPair(it.first, it.second) }

data class Destacadosclass(
    val imagenResId: Int,
    val nombreResId: Int,
    val precioResId: Int
)

private val DestacadosColecction = listOf(
    Destacadosclass(R.drawable.coche1, R.string.HyundaiPrecio, R.string.HuyundaiNombre),
    Destacadosclass(R.drawable.coche2, R.string.KiaPrecio, R.string.KiaNombre),
    Destacadosclass(R.drawable.coche3, R.string.PorschePrecio, R.string.PorscheNombre),
    Destacadosclass(R.drawable.coche4, R.string.lamborghiniPrecio, R.string.lamborghiniNombre),
    Destacadosclass(R.drawable.coche5, R.string.BmwPrecio, R.string.BmwNombre),

    )

@Composable
fun MuyBuscadoGrid(
    modifier: Modifier = Modifier
) {
    Column {
        Text(
            text = "Muy buscado en tu zona",
            modifier = Modifier
                .paddingFromBaseline(top = 5.dp, bottom = 20.dp)
                .align(Alignment.Start)
                .padding(start = 16.dp),
            style = MaterialTheme.typography.titleLarge
        )

        LazyHorizontalGrid(
            rows = GridCells.Fixed(1),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier.height(100.dp)
        ) {
            items(muybuscadoColeccion) { item ->
                MuyBuscado(item.drawable, item.text)
            }
        }
    }
}

@Composable
fun Destacados(
    @DrawableRes drawable: Int,
    @StringRes precio: Int,
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
            text= stringResource(precio),
            modifier = Modifier
                .paddingFromBaseline(top = 0.dp, bottom = 8.dp)
                .align(Alignment.Start),
            style = MaterialTheme.typography.titleMedium)

        Text(
            text= stringResource(text),
            modifier = Modifier
                .paddingFromBaseline(top = 0.dp, bottom = 8.dp)
                .align(Alignment.Start),
            style = MaterialTheme.typography.bodyMedium)

        Text(
            text= "Destacado",
            modifier = Modifier
                .paddingFromBaseline(top = 10.dp, bottom = 8.dp)
                .align(Alignment.Start),
            style = MaterialTheme.typography.bodySmall)
    }
}

@Composable
fun DestacadoGrid(
    modifier: Modifier = Modifier
) {
    Text(
        text = "Destacados",
        modifier = Modifier
            .paddingFromBaseline(top = 5.dp, bottom = 20.dp)
            .padding(start = 16.dp),
        style = MaterialTheme.typography.titleLarge
    )

    LazyRow(modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(DestacadosColecction){
                item -> Destacados(item.imagenResId,item.nombreResId,item.precioResId)
        }
    }

}
@Composable
private fun BarraDeNavegacion(modifier: Modifier = Modifier) {
    NavigationBar(
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.surfaceVariant
    )
    {
        NavigationBarItem(
            selected = true ,
            onClick = { /*TODO*/ },
            icon = { Icon(imageVector = Icons.Default.Home , contentDescription = null ) },
            label = { Text(text = stringResource(R.string.Inicio))}
        )

        NavigationBarItem(
            selected = false,
            onClick = { /*TODO*/ },
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

@Composable
fun Aplicacion(modifier: Modifier = Modifier) {
    // Implement composable here
    Column(modifier
        .verticalScroll(rememberScrollState())) {
        SearchBar(Modifier.padding(horizontal = 10.dp))
        Spacer(Modifier.height(20.dp))
        MuyBuscadoGrid()
        Spacer(Modifier.height(50.dp))
        CategoriasRow()
        Spacer(Modifier.height(50.dp))
        DestacadoGrid()
        Spacer(Modifier.height(50.dp))

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySootheAppPortrait() {

    Practica04Theme {
        Scaffold(
            bottomBar = { BarraDeNavegacion() }
        ) {
                padding -> Aplicacion(Modifier.padding(padding))
        }
    }


}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Practica04Theme {
        SearchBar()
    }
}

@Preview(showBackground = true)
@Composable
fun MuyBuscado1() {
    Practica04Theme {
        MuyBuscado(drawable = R.drawable.muybuscado, text = R.string.Iphone,
            modifier = Modifier.padding(8.dp))
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFF)
@Composable
fun muybuscadosGrid() {
    Practica04Theme {
            MuyBuscadoGrid()

        }

    }


@Preview(widthDp = 360, heightDp = 640, showBackground = true,backgroundColor = 0xFFFFFF,
    showSystemUi = false
)
@Composable
fun MySoothePortraitPreview() {
    MySootheAppPortrait()
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun CategoriasPreview() {
    Practica04Theme {
        Categorias(drawable = R.drawable.emoticonocoche, text = R.string.Coches,
            modifier = Modifier.padding(8.dp))
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun CategoriasRowPreview() {
    Practica04Theme { CategoriasRow() }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun DestacadosPreviwew() {
    Practica04Theme {
        Destacados(drawable = R.drawable.coche1, text = R.string.HuyundaiNombre, precio = R.string.HyundaiPrecio,
            modifier = Modifier.padding(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DestacadosGridPreview() {
    Practica04Theme {
        DestacadoGrid()
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F0EE)
@Composable
fun BarraNavegacionPreview() {
    Practica04Theme { BarraDeNavegacion(Modifier.padding(top = 24.dp)) }
}