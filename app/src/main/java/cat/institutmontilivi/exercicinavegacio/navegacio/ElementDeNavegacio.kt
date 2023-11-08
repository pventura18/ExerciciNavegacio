package cat.institutmontilivi.exercicinavegacio.navegacio

import androidx.navigation.NavType

sealed class ElementDeNavegacio(
    val rutaBase : String,
    val argumentsDeNavegacio : List<ArgumentDeNavegacio> = emptyList(),
    val rutaSencera : String = run{
        // rutaBase/{arg1}/{arg2}/.../{argN}
        val clausArguments = argumentsDeNavegacio.map{
            "{${it.clau}}"
        }
        listOf(rutaBase)
            .plus(clausArguments)
            .joinToString(separator = "/")
    }
){
    object Principal : ElementDeNavegacio("principal")
    object CaraCreu : ElementDeNavegacio("caraCreu")
    object Numeros : ElementDeNavegacio("numeros" , listOf(ArgumentDeNavegacio.Minim, ArgumentDeNavegacio.Maxim)){
        fun creaRutaDeNavegacio(minim : Int, maxim : Int) = "$rutaBase/${minim.toString()}/${maxim.toString()}"
    }
    object Oracle : ElementDeNavegacio("oracle")
    object Resposta : ElementDeNavegacio("resposta", listOf(ArgumentDeNavegacio.Pregunta)){
        fun creaRutaDeNavegacio(pregunta : String) = "$rutaBase/${pregunta}"
    }
}

enum class ArgumentDeNavegacio(
    val clau : String,
    val tipus : NavType<*>
){
    Pregunta (
        clau = "pregunta",
        tipus = NavType.StringType
    ),
    Minim(
        clau = "minim",
        tipus = NavType.IntType
    ),
    Maxim(
        clau = "maxim",
        tipus = NavType.IntType
    )

}