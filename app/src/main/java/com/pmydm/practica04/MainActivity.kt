package com.pmydm.practica04

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
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
                .heightIn(min = 56.dp))


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
                .width(140.dp)
                .height(100.dp),
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
                contentScale = ContentScale.FillHeight



            )

        }
    }
}

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)

private val muybuscadoColeccion = listOf(
    R.drawable.muybuscado to R.string.Iphone,
    R.drawable.coche to R.string.Coche,
    R.drawable.switch1 to R.string.Switch,

).map { DrawableStringPair(it.first, it.second) }

@Composable
fun MuyBuscadoGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.height(100.dp)
    ){
        items(muybuscadoColeccion){
                item ->
            MuyBuscado(item.drawable,item.text)
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

@Preview(showBackground = true)
@Composable
fun muybuscadosGrid() {
    Practica04Theme {
        MuyBuscadoGrid()
    }
}
