package cat.institutmontilivi.exercicinavegacio.navegacio

import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cat.institutmontilivi.exercicinavegacio.Pantalles.PantallaCaraCreu
import cat.institutmontilivi.exercicinavegacio.Pantalles.PantallaNumerosRandom
import cat.institutmontilivi.exercicinavegacio.Pantalles.PantallaPrincipal
import cat.institutmontilivi.exercicinavegacio.Pantalles.PantallaOracle
import cat.institutmontilivi.exercicinavegacio.Pantalles.PantallaResposta

@Composable
fun Navegacio(){
    //Creem el navegador

    val controladorDeNavegacio = rememberNavController()

    NavHost(navController = controladorDeNavegacio,
        startDestination = ElementDeNavegacio.Principal.rutaBase){
        composable(ElementDeNavegacio.Principal.rutaSencera){
            PantallaPrincipal(
                onNavegaCaraCreu = {
                    controladorDeNavegacio.navigate(ElementDeNavegacio.CaraCreu.rutaSencera)
                },
                onNavegaNumeros = {minim : Int, maxim : Int ->
                    controladorDeNavegacio.navigate(ElementDeNavegacio.Numeros.creaRutaDeNavegacio(minim, maxim))
                },
                onNavegaOracle = {
                    controladorDeNavegacio.navigate(ElementDeNavegacio.Oracle.rutaSencera)
                }
            )
        }

        composable(ElementDeNavegacio.CaraCreu.rutaSencera){
            PantallaCaraCreu(
                onNavegaInici = {controladorDeNavegacio.navigate(ElementDeNavegacio.Principal.rutaSencera)}
            )
        }

        composable(
            route = ElementDeNavegacio.Numeros.rutaSencera,
            arguments = listOf(
                navArgument(ElementDeNavegacio.Numeros.argumentsDeNavegacio[0].clau){type = NavType.IntType},
                navArgument(ElementDeNavegacio.Numeros.argumentsDeNavegacio[1].clau){type = NavType.IntType}
            )
        ){
            val minim = it.arguments?.getInt(ElementDeNavegacio.Numeros.argumentsDeNavegacio[0].clau)
            val maxim = it.arguments?.getInt(ElementDeNavegacio.Numeros.argumentsDeNavegacio[1].clau)
            requireNotNull(minim,{"Error el text no pot ser null"})
            requireNotNull(maxim,{"Error el text no pot ser null"})

            PantallaNumerosRandom(minim = minim, maxim = maxim+1,
                onNavegaInici = {controladorDeNavegacio.navigate(ElementDeNavegacio.Principal.rutaSencera)}
            )
        }

        composable(ElementDeNavegacio.Oracle.rutaSencera){
            PantallaOracle(
                onNavegaResposta = {
                        pregunta : String ->
                    controladorDeNavegacio.navigate(ElementDeNavegacio.Resposta.creaRutaDeNavegacio(pregunta)){
                        popUpTo(ElementDeNavegacio.Principal.rutaSencera)
                    } },
                onNavegaInici = {controladorDeNavegacio.navigate(ElementDeNavegacio.Principal.rutaSencera) }
            )
        }

        composable(
            route = ElementDeNavegacio.Resposta.rutaSencera,
            arguments = listOf(
                navArgument(ElementDeNavegacio.Resposta.argumentsDeNavegacio[0].clau){type = NavType.StringType}
            )
        ){
            val pregunta = it.arguments?.getString(ElementDeNavegacio.Resposta.argumentsDeNavegacio[0].clau)
            requireNotNull(pregunta,{"Error la pregunta no pot ser null"})

            PantallaResposta(pregunta)
        }



    }
}