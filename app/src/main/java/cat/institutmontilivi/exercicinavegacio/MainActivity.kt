package cat.institutmontilivi.exercicinavegacio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cat.institutmontilivi.exercicinavegacio.navegacio.Navegacio
import cat.institutmontilivi.exercicinavegacio.ui.theme.ExerciciNavegacioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExerciciNavegacioTheme {
                // A surface container using the 'background' color from the theme
                TemaApp{
                    Navegacio()
                }
            }
        }
    }
}

@Composable
fun TemaApp(content : @Composable () -> Unit){
    ExerciciNavegacioTheme {
        Surface (
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ){
            content()
        }
    }
}