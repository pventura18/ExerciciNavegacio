package cat.institutmontilivi.exercicinavegacio.Pantalles

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cat.institutmontilivi.exercicinavegacio.R



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaOracle(
    onNavegaResposta : (String) -> Unit,
    onNavegaInici : () -> Unit
) {
    Scaffold (
        topBar ={
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Oracle")
                },
                navigationIcon= {
                    IconButton(onClick = {onNavegaInici()}) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Pantalla Principal"
                        )


                    }
                }
            )
        },
    ){
            innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)){
            ContingutOracle(onNavegaResposta)
        }


    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContingutOracle(onNavegaResposta : (String) -> Unit){
    var question by remember { mutableStateOf("Guanyarà el Girona la lliga?") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.fons),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.geni01),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )
            Column(modifier = Modifier.weight(1f)){
                Text(
                    text = "Escriu la teva pregunta:",
                    color = Color.Blue,
                    fontSize = 40.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 20.dp)
                )

                var pregunta by remember {mutableStateOf("")}

                TextField(value = pregunta,
                    onValueChange = {pregunta = it},
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f))

                Button(
                    onClick = {
                        if(pregunta == null || pregunta == "") pregunta = "Entra una pregunta"
                        else onNavegaResposta(pregunta)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.geni04),
                            contentDescription = null,
                            modifier = Modifier.size(50.dp)
                        )
                        Text(
                            text = "Respon!",
                            color = Color.Blue,
                            fontSize = 20.sp,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}