package cat.institutmontilivi.exercicinavegacio.Pantalles

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal(
    onNavegaCaraCreu : () -> Unit,
    onNavegaNumeros : (Int, Int) -> Unit,
    onNavegaOracle : () -> Unit
){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Menu Principal") },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(onClick = { }){
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Pantalla Principal"
                        )
                    }
                }
            )
        }
    ){ innerPadding ->
            Column(
                modifier= Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.Center
            ) {

                //Botó Cara i Creu
                Button(onClick = {onNavegaCaraCreu()},
                    modifier= Modifier
                        .fillMaxWidth()

                )
                {
                    Text(text = "Cara i Creu",
                        style = MaterialTheme.typography.headlineLarge

                    )

                }
                Spacer(modifier = Modifier.height(24.dp))


                //Botó i camps Numeros random
                var minim by remember {mutableStateOf("0")}
                var maxim by remember {mutableStateOf("10")}
                Row(){
                    TextField(value = minim,
                        onValueChange = {minim = it},
                        label = { Text("Minim")},
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                        modifier = Modifier.weight(1f))

                    Spacer(modifier = Modifier.width(20.dp))

                    TextField(value = maxim,
                        onValueChange = {maxim = it},
                        label = { Text("Maxim")},
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                        modifier = Modifier.weight(1f))
                }
                Spacer(modifier = Modifier.height(10.dp))
                Button(onClick = {
                    if(minim == null || minim == "" || maxim == null || maxim == "") {
                        minim = "0"
                        maxim = "5"
                    }
                    else onNavegaNumeros(minim.toInt(), maxim.toInt())
                },
                    modifier= Modifier
                        .fillMaxWidth()

                )
                {
                    Text(text = "Numero Random",
                        style = MaterialTheme.typography.headlineLarge

                    )

                }


                //Botó Oracle
                Spacer(modifier = Modifier.height(24.dp))
                Button(onClick = {onNavegaOracle()},
                    modifier= Modifier
                        .fillMaxWidth()

                )
                {
                    Text(text = "Oracle",
                        style = MaterialTheme.typography.headlineLarge

                    )

                }

            }


    }
}

