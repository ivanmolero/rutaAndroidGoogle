
/*
 * Ejemplo sobre el uso de when, curso de ANDROID BASICS WITH COMPOSE
 * */
fun main(args: Array<String>) {
}

///*
// * Ejemplo sobre el uso de when, curso de ANDROID BASICS WITH COMPOSE
// * para este ejemplo tomamos el codigo anterior sobre el semaforo y agregamos
// * una nueva luz, al lado de "Yellow" ya que "Amber" se usa para la misma
// * situación, extendiendo los valores soportados por la segunda rama
// * */
//fun main(args: Array<String>) {
//    val trafficLightColor = "Amber"
//
//    when (trafficLightColor) {
//        "Red" -> println("Stop")
//        "Yellow", "Amber" -> println("Slow")
//        "Green" -> println("Go")
//        else -> println("Invalid traffic-light color")
//    }
//}

///*
// * Ejemplo sobre el uso de when, curso de ANDROID BASICS WITH COMPOSE
// * en la primera linea se busca la coincidencia con valores separados por coma
// * en la segunda linea se busca la coincidencia con un rango de valores, para
// * el caso entre 1 y 10, la palabra reservada es 'in'
// * en la tercera linea se busca la coincidencia con un tipo de dato, para el
// * caso es el tipo Ing, la palabra reservada es 'is'
// * la cuarta linea verifica cualquier otra situación, el mensaje ahora debe ser
// * sobre el tipo de datos, ya que, en este ejemplo, el tipo de datos es Double
// * al ser asignado el valor de 16.0 que es un double
// * */
//fun main(args: Array<String>) {
//    val x: Any = 16.0
//
//    when (x) {
//        2, 3, 5, 7 -> println("x is a prime number between 1 and 10.")
//        in 1..10 -> println("x is a number between 1 and 10, but not a prime number.")
//        is Int -> println("x is an integer number, not between 1 and 10.")
//        else -> println("x isn't an integer number.")
//    }
//}


///*
// * Ejemplo sobre el uso de when, curso de ANDROID BASICS WITH COMPOSE
// * se hace la evaluación de varios valores con el mismo proceso de impresion,
// * ojo que no tiene cambios ni en el contenido del mensaje a mostrar
// * */
//fun main(args: Array<String>) {
//    val x = 3
//
//    when (x) {
//        2 -> println("x is a prime number between 1 and 10.")
//        3 -> println("x is a prime number between 1 and 10.")
//        5 -> println("x is a prime number between 1 and 10.")
//        7 -> println("x is a prime number between 1 and 10.")
//        else -> println("x isn't a prime number between 1 and 10.")
//    }
//}

///*
// * Ejemplo sobre el uso de when, curso de ANDROID BASICS WITH COMPOSE
// * aplicado sobre el ejemplo anterior se puede usar para mostrar mejor la
// * lógica usada detrás de que hacer con los valores tomados por la variable
// * trafficLightColor
// * */
//fun main(args: Array<String>) {
//    val trafficLightColor = "Yellow"
//
//    when (trafficLightColor) {
//        "Red" -> println("Stop")
//        "Yellow" -> println("Slow")
//        "Green" -> println("Go")
//        else -> println("Invalid traffic-light color")
//    }
//}

///*
// * Ejemplo sobre el uso de if, curso de ANDROID BASICS WITH COMPOSE
// * muestra el uso de una sentencia if, con else-if anidados para evaluación
// * múltiple de condiciones y un else final para control de opciones no
// * evaluadas o previstas
// * */
//fun main(args: Array<String>) {
//    val trafficLightColor = "Black"
//
//    if (trafficLightColor == "Red") {
//        println("Stop")
//    } else if (trafficLightColor == "Yellow") {
//        println("Slow")
//    } else if (trafficLightColor == "Green") {
//        println("Go")
//    } else {
//        println("Invalid traffic-light color")
//    }
//}