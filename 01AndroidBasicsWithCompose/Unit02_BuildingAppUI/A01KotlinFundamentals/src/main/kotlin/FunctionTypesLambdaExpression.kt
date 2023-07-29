
/*
 * Ejemplo sobre el uso de funciones y lambdas, curso de ANDROID BASICS WITH COMPOSE
 * cuando una función devuelve una función o toma una función como argumento, estamos
 * ante una higher-order function, trickOrTreat es una higher-order function
 * Kotlin tiene varias de estas funciones disponibles, entre estas esta la función
 *     repeat(times: Int, action: (Int) -> Unit)
 * es posible llamar varias veces una función usando repeat(), como se ve en el metodo
 * main siguiente
 * */

fun main() {
    val treatFunction = trickOrTreat(false) { "$it quarters" }
    val trickFunction = trickOrTreat(true, null)
    repeat(5) {
        treatFunction()
    }
    trickFunction()
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
    return if (isTrick) {
        trick
    } else {
        if (extraTreat != null) {
            println(extraTreat(5))
        }
        treat
    }
}

val trick = {
    println("no treats!")
}

val treat: () -> Unit = {
    println("have a treat!")
}

///*
// * Ejemplo sobre el uso de funciones y lambdas, curso de ANDROID BASICS WITH COMPOSE
// * ya que la función coins sólo se usa una vez, es posible pasar la expresion directamente
// * en el sitio de uso
// *     val treatFunction = trickOrTreat(false, { "$it quarters" } )
// * en vez de enviar la función por variable se envia el contenido de la misma
// * hay otra forma válida para escribir lo mismo, es el trailing lambda syntax,
// * permite escribir la lambda fuera del parentesis al ser la lambda el último parametro
// * de la función, de esta forma
// *     val treatFunction = trickOrTreat(false) { "$it quarters" }
// * el resultado es el mismo
// * */
//
//fun main() {
////    val coins: (Int) -> String = {
////        "$it quarters"
////    }
//
//    val cupcake: (Int) -> String = {
////        quantity -> "have a cupcake!"
//        "have a cupcake!"
//    }
//
////    val treatFunction = trickOrTreat(false, { "$it quarters" } )
//    val treatFunction = trickOrTreat(false) { "$it quarters" }
//    val trickFunction = trickOrTreat(true, null)
//    treatFunction()
//    trickFunction()
//}
//
//fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
//    return if (isTrick) {
//        trick
//    } else {
//        if (extraTreat != null) {
//            println(extraTreat(5))
//        }
//        treat
//    }
//}
//
//val trick = {
//    println("no treats!")
//}
//
//val treat: () -> Unit = {
//    println("have a treat!")
//}

///*
// * Ejemplo sobre el uso de funciones y lambdas, curso de ANDROID BASICS WITH COMPOSE
// * es posible escribir funciones lambda de manera más corta
// * escribiremos la funcion coins para que sea más corta, se usa 'it' para referirse
// * de manera implicita al parametro entrante
// * */
//
//fun main() {
//    val coins: (Int) -> String = {
//            "$it quarters"
//    }
//
//    val cupcake: (Int) -> String = {
////        quantity -> "have a cupcake!"
//        "have a cupcake!"
//    }
//
//    val treatFunction = trickOrTreat(false, coins)
//    val trickFunction = trickOrTreat(true, null)
//    treatFunction()
//    trickFunction()
//}
//
//fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
//    return if (isTrick) {
//        trick
//    } else {
//        if (extraTreat != null) {
//            println(extraTreat(5))
//        }
//        treat
//    }
//}
//
//val trick = {
//    println("no treats!")
//}
//
//val treat: () -> Unit = {
//    println("have a treat!")
//}

///*
// * Ejemplo sobre el uso de funciones y lambdas, curso de ANDROID BASICS WITH COMPOSE
// * como cualquier otro tipo de variable, tambien es posible que estas puedan ser
// * nullables, es decir, que puedan devolver un null
// * si hacemos el parametro extraTreat nullable entonces no será obligatorio ponerlo
// * cada vez que se llame a trickOrTreat, para eso basta con
// *     extraTreat: ((Int) -> String)?
// * rodear el tipo entre parentesis y finalizarlo con ?
// * finalmente es necesario validar que no sea null para poder
// * usarlo, ver el else de isTrick
// * ahora se puede hacer esto en la segunda llamada
// *     val trickFunction = trickOrTreat(true, null)
// * ya que al enviar un valor true no es necesario enviar el
// * método, ya que es nullable
// * al declarar el parametro nullable no es obligatorio pasar
// * el método como parametro, basta con pasar un null
// * */
//
//fun main() {
//    val coins: (Int) -> String = {
//            quantity -> "$quantity quarters"
//    }
//
//    val cupcake: (Int) -> String = {
////        quantity -> "have a cupcake!"
//        "have a cupcake!"
//    }
//
//    val treatFunction = trickOrTreat(false, coins)
//    val trickFunction = trickOrTreat(true, null)
//    treatFunction()
//    trickFunction()
//}
//
//fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)?): () -> Unit {
//    return if (isTrick) {
//        trick
//    } else {
//        if (extraTreat != null) {
//            println(extraTreat(5))
//        }
//        treat
//    }
//}
//
//val trick = {
//    println("no treats!")
//}
//
//val treat: () -> Unit = {
//    println("have a treat!")
//}

///*
// * Ejemplo sobre el uso de funciones y lambdas, curso de ANDROID BASICS WITH COMPOSE
// * tambien es posible no solo devolver funciones, sino recibirlas como parte de los
// * parametros de una función
// * ahora vamos a agregar una función más como argumento de la función trickOrTreat()
// *     extraTreat: (Int) -> String
// * esta parte es un atributo tipo función, que tiene un parametro entero y devuelve
// * un string, las invocaciones iniciales dejaron de funcionar, falta un metodo
// * creamos un metodo y lo guardamos en la variable coins, tiene la forma de
// * extraTreat, es decir, es (Int) -> String
// * tambien podemos crear otro llamado cupcake, con la misma lógica y como no hace uso
// * del parametro de entrada puede omitirse esa parte
// * es necesario aclarar que el nombres usado 'quantity' puede ser cualquier otro o,
// * si se omite, se puede simplemente usar 'it'
// * ahora si usamos ambos metodos como parametro de trickOrTread()
// * si se ejecuta es necesario recordar que extraTreat() solo se ejecuta al ser el
// * valor booleano true
// * */
//
//fun main() {
//    val coins: (Int) -> String = {
//        quantity -> "$quantity quarters"
//    }
//
//    val cupcake: (Int) -> String = {
////        quantity -> "have a cupcake!"
//        "have a cupcake!"
//    }
//
//    val treatFunction = trickOrTreat(false, coins)
//    val trickFunction = trickOrTreat(true, cupcake)
//    treatFunction()
//    trickFunction()
//}
//
//fun trickOrTreat(isTrick: Boolean, extraTreat: (Int) -> String): () -> Unit {
//    return if (isTrick) {
//        trick
//    } else {
//        println(extraTreat(5))
//        treat
//    }
//}
//
//val trick = {
//    println("no treats!")
//}
//
//val treat: () -> Unit = {
//    println("have a treat!")
//}

///*
// * Ejemplo sobre el uso de funciones y lambdas, curso de ANDROID BASICS WITH COMPOSE
// * en vista que las funciones son como cualquier otro tipo de dato, es posible
// * que queramos devolver una función desde otra función
// *     fun function_name(): function_type {
// *         return another_function
// *     }
// * en este caso la función trickOrTreat recibe un parametro booleano (isTrick) y
// * devuelve una función () -> Unit, evalua el parametro y hace un return de una u
// * otra función
// * es posible hacer una invocación directa como se ve al inicio del metodo main
// * o una mediada por variables
// * */
//
//fun main() {
////    trickOrTreat(true)()
////    trickOrTreat(false)()
//    val treatFunction = trickOrTreat(false)
//    val trickFunction = trickOrTreat(true)
//    treatFunction()
//    trickFunction()
//}
//
//fun trickOrTreat(isTrick: Boolean): () -> Unit {
//    return if (isTrick) {
//        trick
//    } else {
//        treat
//    }
//}
//
//val trick = {
//    println("no treats!")
//}
//
//val treat: () -> Unit = {
//    println("have a treat!")
//}

///*
// * Ejemplo sobre el uso de funciones y lambdas, curso de ANDROID BASICS WITH COMPOSE
// * Kotlin tiene inferencia de tipo, sin embargo, suele ser necesario especificar el
// * tipo de datos de los parametros y el tipo de datos devuelto por la funcion, para ello
// * se usa una expresion como la siguiente
// *     (optional parameters) -> return type
// * para el caso de la función trick tenemos () -> Unit ya que la función no devuelve
// * nada, en el caso de tener una función que reciba dos parametros de tipo entero y
// * devuelva un entero tenemos (Int, Int) -> Int
// * ahora tenemos una nueva función, treat, esta función la podemos definir de dos
// * formas, una como antes y otra especificando la devolucion () -> Unit, ambas
// * son equivalentes
// * */
//
//fun main() {
//    val trickFunction = trick
//    trickFunction()
//    trick()
//    treat()
//}
//
//val trick = {
//    println("no treats!")
//}
//
////val treat = {
////    println("have a treat!")
////}
//val treat: () -> Unit = {
//    println("have a treat!")
//}

///*
// * Ejemplo sobre el uso de funciones y lambdas, curso de ANDROID BASICS WITH COMPOSE
// * tambien es posible hacer lo mismo usando una expresion lambda, ahora en vez de
// * tener una función como tal, se tiene una variable a la que se le asigna código
// * y esta variable puede ser referida por otra, y hasta la podemos invocar con
// * trickFunction(), usando las expresiones lamba podemos crear variables que almacenen
// * funciones e invocarlas como funciones o usarlas como variables
// * */
//
//fun main() {
//    val trickFunction = trick
//    trickFunction()
//    trick()
//}
//
//val trick = {
//    println("no treats!")
//}

///*
// * Ejemplo sobre el uso de funciones y lambdas, curso de ANDROID BASICS WITH COMPOSE
// * las funciones en Kotlin también son tipos de datos, es decir, se pueden guardar
// * en una variable, en este caso definimos una función de nombre trick() y en el
// * main intentamos asignarla a una variable, vemos que da un error
// * para que esto funcion se necesita el operador de referencia de funcion (::)
// * usandolo si se puede compilar
// * */
//
//fun main() {
////    val trickFunction = trick
//    val trickFunction = ::trick
//}
//
//fun trick() {
//    println("no treats!")
//}
