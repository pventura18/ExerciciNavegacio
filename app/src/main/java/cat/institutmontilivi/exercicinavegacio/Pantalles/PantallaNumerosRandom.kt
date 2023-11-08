package cat.institutmontilivi.exercicinavegacio.Pantalles

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cat.institutmontilivi.exercicinavegacio.R
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaNumerosRandom(
    minim : Int = 0,
    maxim : Int = 10,
    onNavegaInici : () -> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Números Random") },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(onClick = { onNavegaInici()}){
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Pantalla Principal"
                        )
                    }
                }
            )
        }
    ){ innerPadding ->
            Box(
                modifier= Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(24.dp)
            ) {
                var numero by remember { mutableStateOf(Random.nextInt(minim, maxim)) }


                Text(
                    text = numero.toString(),
                    style = MaterialTheme.typography.displayLarge,
                    modifier = Modifier.align(Alignment.Center)
                )
                Button(onClick = {numero = Random.nextInt(minim, maxim)},
                    modifier= Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)

                )
                {
                    Text(text = "Genera!",
                        style = MaterialTheme.typography.headlineLarge
                    )

                }


            }


    }
}