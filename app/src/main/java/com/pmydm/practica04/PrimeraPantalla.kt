package com.pmydm.practica04



import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pmydm.practica04.ui.theme.Practica04Theme

var categoria = mutableStateOf(0)


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrimeraPantalla(navController: NavController){
    Scaffold {
        MySootheAppPortrait(navController)
    }
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
                .clickable { modificar(drawable=drawable) }

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

data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

private val muybuscadoColeccion = listOf(
    R.drawable.muybuscado to R.string.Iphone,
    R.drawable.coche to R.string.Coches,
    R.drawable.switch1 to R.string.Switch,

    ).map { DrawableStringPair(it.first, it.second) }

val CategoriasColeccion = listOf(
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

private val DestacadosColecctionMotos = listOf(
    Destacadosclass(R.drawable.moto1, R.string.Moto1, R.string.Moto1Precio),
    Destacadosclass(R.drawable.moto2, R.string.Moto2, R.string.Moto2Precio),
    Destacadosclass(R.drawable.moto3, R.string.Moto3, R.string.Moto3Precio),
    Destacadosclass(R.drawable.moto4, R.string.Moto4, R.string.Moto4Precio),
    Destacadosclass(R.drawable.moto5, R.string.Moto5, R.string.Moto5Precio),

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
            style = MaterialTheme.typography.titleMedium
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

        var favorito by rememberSaveable { mutableStateOf(0) }

        if(favorito==0){
            IconButton(onClick = {favorito++;DarFav(drawable=drawable)},
                modifier.align(Alignment.End)
            ) {
                Icon(Icons.Default.FavoriteBorder,contentDescription = "",tint = Color.Red)
            }

        }else{
            IconButton(onClick = {favorito--;QuitarFav(drawable=drawable) },
                modifier.align(Alignment.End)) {
                Icon(Icons.Default.Favorite,contentDescription = "",tint = Color.Red)
            }
        }


    }
}

@Composable
fun productoscerca(
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

    }
}

var categorianormal=0


@Composable
fun DestacadoGrid(
    modifier: Modifier = Modifier,

    ) {
    Text(
        text = "Destacados",
        modifier = Modifier
            .paddingFromBaseline(top = 5.dp, bottom = 20.dp)
            .padding(start = 16.dp),
        style = MaterialTheme.typography.titleLarge
    )




    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        if (categoria.value==0){
            items(DestacadosColecction) { item ->
                Destacados(item.imagenResId, item.nombreResId, item.precioResId)
            }
        } else {
            items(DestacadosColecctionMotos) { item ->
                Destacados(item.imagenResId, item.nombreResId, item.precioResId)
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
            selected = true ,
            onClick = { navController.navigate(route = AppScreens.HomePantalla.route) },
            icon = { Icon(imageVector = Icons.Default.Home , contentDescription = null ) },
            label = { Text(text = stringResource(R.string.Inicio))}
        )

        NavigationBarItem(
            selected = false,
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
        Cercademi()

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MySootheAppPortrait(navController: NavController) {

    Practica04Theme {
        Scaffold(
            bottomBar = { BarraDeNavegacion(navController) }
        ) {
                padding -> Aplicacion(Modifier.padding(padding))
        }
    }


}

@Composable
fun Cercademi(
    modifier: Modifier = Modifier
) {
    Column {
        Text(
            text= "Cerca de mi",
            modifier = Modifier
                .padding(start = 16.dp)
                .paddingFromBaseline(top = 10.dp, bottom = 8.dp),
            style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(10.dp))

        LazyHorizontalGrid(
            rows = GridCells.Fixed(3),
            contentPadding = PaddingValues(horizontal = 50.dp),
            horizontalArrangement = Arrangement.spacedBy(50.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = modifier
                .height(800.dp)
                .width(900.dp)
        ){
            items(DestacadosColecction){
                    item ->
                productoscerca(item.imagenResId,item.nombreResId,item.precioResId)
            }
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
fun CercademiPreview() {
    Practica04Theme { Cercademi() }
}