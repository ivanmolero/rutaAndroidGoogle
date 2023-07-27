
/*
 * Ejemplo sobre el uso de nullables, curso de ANDROID BASICS WITH COMPOSE
 * finalmente es posible el uso del operador Elvis ?:, este operador se usa
 * junto al operador safe-call y permite controlar el caso en el que la
 * variable sea null, devolviendo un valor, ambos resultados son iguales a
 * los usados en el bloque anterior pero con mucho menos código y más claro
 * ya que se parece mucho al operador ternario de Java
 * el operador Elvis ?: se llama así en honor a Elvis Presley ya que visto de
 * costado se parece mucho al emoticon de su estilo de peinado
 */

fun main() {
    var favoriteActor: String? = "Sandra Oh"
    var lengthOfName = favoriteActor?.length ?: 0
    println("The number of characters in your favorite actor's name is $lengthOfName")
    favoriteActor = null;
    lengthOfName = favoriteActor?.length ?: 0
    println("The number of characters in your favorite actor's name is $lengthOfName")

}

///*
// * Ejemplo sobre el uso de nullables, curso de ANDROID BASICS WITH COMPOSE
// * otra forma es usando la capacidad de expresión del if y asignando un valor
// * en caso que nos encontremos con un valor null, se aligera y aclara un poco
// * el código anterior
// */
//
//fun main() {
//    var favoriteActor: String? = "Sandra Oh"
//
//    var lengthOfName = if (favoriteActor != null) {
//        favoriteActor.length
//    } else {
//        0
//    }
//    println("The number of characters in your favorite actor's name is $lengthOfName")
//
//    favoriteActor = null
//
//    lengthOfName = if (favoriteActor != null) {
//        favoriteActor.length
//    } else {
//        0
//    }
//    println("The number of characters in your favorite actor's name is $lengthOfName")
//}

///*
// * Ejemplo sobre el uso de nullables, curso de ANDROID BASICS WITH COMPOSE
// * otra forma de controlar el valor null, es por medio de un if que valida
// * si la variable tiene o no el valor null, tomando una acción en caso se
// * encuentre el valor null en la variable.
// */
//
//fun main() {
//    var favoriteActor: String? = "Sandra Oh"
//
//    if (favoriteActor != null) {
//        println("The number of characters in your favorite actor's name is ${favoriteActor.length}.")
//    } else {
//        println("You didn't input a name.")
//    }
//
//    favoriteActor = null
//
//    if (favoriteActor != null) {
//        println("The number of characters in your favorite actor's name is ${favoriteActor.length}.")
//    } else {
//        println("You didn't input a name.")
//    }
//}

///*
// * Ejemplo sobre el uso de nullables, curso de ANDROID BASICS WITH COMPOSE
// * si solo se ejecutan las dos primeras lineas, la salida es la esperada, el
// * operador !! not-null assertion, asegura que la variable nullable no es
// * nula en este momento del código, pero si agregamos las dos siguientes
// * lineas, vemos que la variable tiene un valor null, y si usamos el operador
// * !! entonces tenemos ahora un tipo de error de compilación, o el lanzamiento
// * de una excepción de tipo NullPointerException
// */
//
//fun main() {
//    var favoriteActor: String? = "Sandra Oh"
//    println(favoriteActor!!.length)
//    favoriteActor = null
//    println(favoriteActor!!.length)
//}

///*
// * Ejemplo sobre el uso de nullables, curso de ANDROID BASICS WITH COMPOSE
// * una forma de controlar una variable nullable es usando el operador
// * safe-call representado por el simbolo ?
// * usando eso el código se puede ejecutar, además, si le asignamos a la
// * variable el valor null, tambien se puede ejecutar el mismo código de
// * antes pero el valor devuelto es null, como se ve en la salida del
// * programa, esta es una forma segura de no
// */
//
//fun main() {
//    var favoriteActor: String? = "Sandra Oh"
//    println(favoriteActor?.length)
//    favoriteActor = null
//    println(favoriteActor?.length)
//}

///*
// * Ejemplo sobre el uso de nullables, curso de ANDROID BASICS WITH COMPOSE
// * si hacemos lo mismo para una variable de tipo nullable, en este caso un
// * tipo String?, obtenemos un error
// * Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable
// * receiver of type String?
// * no es posible llamar de manera segura a un metodo o atributo de una
// * variable no nullable
// * este error es un error de compilación y surge cuando Kotlin no puede llevar
// * a cabo la compilación d ela aplicación
// */
//
//fun main() {
//    var favoriteActor: String? = "Sandra Oh"
//    println(favoriteActor.length)
//}

///*
// * Ejemplo sobre el uso de nullables, curso de ANDROID BASICS WITH COMPOSE
// * se tiene una variable no nullable de tipo String, y se imprime la longitud
// * de la cadena (length) desde la variable, como es de esperarse no hay
// * problemas con el código ya que la variable es de tipo no nullable.
// */
//
//fun main() {
//    var favoriteActor: String = "Sandra Oh"
//    println(favoriteActor.length)
//}

///*
// * Ejemplo sobre el uso de nullables, curso de ANDROID BASICS WITH COMPOSE
// * ejercicio: cree una variable numerica nullable, primero asigne un numero
// * luego lo imprime, posteriormente le asigna null y lo imprime.
// * si una variable no va a ser asignada con null, no es bueno hacerla nullable
// * además es mejor adoptar un enfoque que permita evitar el uso de nullables
// * en el desarrollo de aplicaciones con Kotlin, en Java el manejo de nullables
// * es por default y no hay posibilidad de usar variables no nullables.
// */
//
//fun main() {
//    var number: Int? = 10
//    println(number)
//
//    number = null
//    println(number)
//}

///*
// * Ejemplo sobre el uso de nullables, curso de ANDROID BASICS WITH COMPOSE
// * para poder hacer la reasignación es necesario que la variable sea declarada
// * explicitamente como un tipo de variable nullable colocando al final del
// * tipo de datos el simbolo ?, que indica que dicha variable puede tomar un
// * valor null, esa modificación hace que el código anterior se pueda ejecutar.
// */
//
//fun main() {
//    var favoriteActor: String? = "Sandra Oh"
//    println(favoriteActor)
//    favoriteActor = null
//    println(favoriteActor)
//}

///*
// * Ejemplo sobre el uso de nullables, curso de ANDROID BASICS WITH COMPOSE
// * puede ser necesario que una variable con un valor asignado, en este caso
// * un String, deba ser reasignada a un valor null, para ello la variable debe
// * ser modificable, es decir, no debe ser val, debe ser var, y si hacemos la
// * modificación nos topamos con un error como el que sale acá
// * Null can not be a value of a non-null type String
// */
//
//fun main() {
//    var favoriteActor = "Sandra Oh"
//    println(favoriteActor)
//    favoriteActor = null
//    println(favoriteActor)
//}

///*
// * Ejemplo sobre el uso de nullables, curso de ANDROID BASICS WITH COMPOSE
// * es posible declarar una variable y, sin indicar el tipo, asignarle un
// * valor null, el tipo será un tipo nullable (String?), es por ello que se
// * puede hacer la asignación y se puede hacer el uso cuando la variable es
// * null.
// */
//
//fun main() {
//    val favoriteActor = null
//    println(favoriteActor)
//}