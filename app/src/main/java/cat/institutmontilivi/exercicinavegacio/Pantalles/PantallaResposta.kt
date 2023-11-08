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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cat.institutmontilivi.exercicinavegacio.R
import kotlin.random.Random

@Preview
@Composable
fun PreviewResposta(){
    PantallaResposta("Guanyarà el girona la lliga?")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaResposta(
    pregunta : String = "Aqui anirà la teva pregunta."
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Resposta") },
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
    )
    {
        innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)){
            RespostaContent(pregunta)
        }
    }
}


@Composable
fun RespostaContent(
    pregunta : String = "Aqui va la teva pregunta"
){
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
            var numImatge by remember { mutableStateOf(1) }
            var numResposta by remember {mutableStateOf(1)}
            val respostes = listOf("Si","No","Potser","Qui sap", "No ho se", "Que va!", "No ho crec...", "Tant de bo saber-ho!")
            numImatge = Random.nextInt(1, 12)
            numResposta = Random.nextInt(respostes.size)

            Text(
                text = pregunta,
                color = Color.Blue,
                fontSize = 40.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 20.dp)
            )

            Image(
                painter = if(numImatge == 1) painterResource(id = R.drawable.geni01)
                else if(numImatge == 2) painterResource(id = R.drawable.geni02)
                else if(numImatge == 3) painterResource(id = R.drawable.geni03)
                else if(numImatge == 4) painterResource(id = R.drawable.geni04)
                else if(numImatge == 5) painterResource(id = R.drawable.geni05)
                else if(numImatge == 6) painterResource(id = R.drawable.geni06)
                else if(numImatge == 7) painterResource(id = R.drawable.geni07)
                else if(numImatge == 8) painterResource(id = R.drawable.geni08)
                else if(numImatge == 9) painterResource(id = R.drawable.geni09)
                else if(numImatge == 10) painterResource(id = R.drawable.geni10)
                else painterResource(id = R.drawable.geni11)
                ,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            )

            Text(
                text = respostes[numResposta],
                color = Color.Black,
                fontSize = 40.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 20.dp)
            )
        }
    }

}