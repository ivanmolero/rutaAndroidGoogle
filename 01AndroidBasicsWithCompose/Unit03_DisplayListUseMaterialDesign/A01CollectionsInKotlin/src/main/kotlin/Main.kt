/*
 * los Map son conjuntos de pares clave-valor, donde la clave (key) es única, como en el set,
 * mientras que el valor puede ser repetido, como en los otros casos se pueden crear de dos
 * formas, usando el mapOf() para un  mapa inmutable y el mutableMapOf() para un mapa mutable
 * es necesario especificar el tipo si no se proveen datos de donde inferirlo como en el caso
 * de mutableMapOf<String, Int>(), finalmente los pares se asocian como key to value para su
 * ingreso al mapa
 * para agregar un elemento al mapa o actualizar uno, es necesario sólo identificarlo usando el
 * key como en mapa[key] = value, y así se ingresa un nuevo par, para obtener el value basta con
 * usar el get usando el key, mapa.get(key) y devuelve el value o un null en caso de no estar la
 * key en el mapa, tambien se puede acceder al value usando la key como posición, como map[key]
 * devuelve el value
 * **/
fun main() {
    val solarSystem = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )
    println(solarSystem)
    println(solarSystem.size)
    solarSystem["Pluto"] = 5
    println(solarSystem)
    println(solarSystem.size)
    println(solarSystem.get("Theia"))
    println(solarSystem.get("Saturn"))
    println(solarSystem["Saturn"])
    solarSystem["Jupiter"] = 78
    println(solarSystem["Jupiter"])
}

/*
 * un Set es un conjunto de elementos que no tienen un orden en específico, de ahi que no podamos
 * acceder a los elementos por posición ya que no tienen posición, además, un Set no permite tener
 * valores duplicados
 * implementar esto es posible por el uso de la función hashCode, que, ante una pequeña variación de
 * contenido (que contenido es otra cosa) altera el resultado del hash devuelto, por eso se puede
 * saber que objeto es diferente de quien, además es posible tener una colisión de hash pero la
 * probablidad de eso es muy baja
 * el principal beneficio de una lista es asegurar que los elementos que la forman son unicos
 * tambien tienen dos formas, setOf o mutableSetOf
 * para agregar un elemento se puede usar .add(elemento)
 * además, para validar si un elemento está se puede usar .contains(elemento) o elemento in set
 * y para eliminar un elemento basta con usar .remove(elemento) y no es posible usar un indice para
 * eliminar un elemento ya que no tiene indices
 * **/
//fun main() {
//    val solarSystem = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
//    println(solarSystem)
//    println(solarSystem.size)
//    solarSystem.add("Pluto")
//    println(solarSystem)
//    println(solarSystem.size)
//    println(solarSystem.contains("Pluto"))
//    println("Pluto" in solarSystem)
//    solarSystem.remove("Pluto")
//    println(solarSystem)
//    println(solarSystem.size)
//    println("Pluto" in solarSystem)
//}

/*
 * para poder agregar o eliminar contenido de una lista es necesario que la lista sea
 * una lista mutable, cambia la función de listOf a mutableListOf
 * para agregar un elemento a una lista mutable se puede usar .add en dos formas, .add(elemento)
 * lo agrega al final de la lista o .add(posición, elemento) lo inserta en la posición enviada
 * la actualización de un valor se da actualizando un elemento en una posición solarSystem[3] = nuevo valor
 * eliminar un elemento de la lista es sencillo, es eliminarlo por posición o por valor usando
 * .removeAt(posicion) o .remove(valor)
 * consultar si un elemento existe se puede hacer de varias formas, usando .contains(valor) o
 * valor in lista
 * **/
//fun main() {
//    val solarSystem = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
//    solarSystem.add("Pluto")
//    solarSystem.add(3, "Theia")
//    println(solarSystem)
//    solarSystem[3] = "Future Moon"
//    println(solarSystem[3])
//    println(solarSystem[9])
//    solarSystem.removeAt(9)
//    solarSystem.remove("Future Moon")
//    println(solarSystem)
//    println(solarSystem.contains("Pluto"))
//    println("Future Moon" in solarSystem)
//}

/*
 * las lista, a diferencia de los arreglos, son elementos más complejos ya que
 * poseen una serie de funciones que facilitan varias labores en ellas, por ejemplo
 * es posible conversión automatica en un string, además es posible acceder a sus
 * elemento por posición usando get o usando [index], se prefiere esta última forma
 * y se puede obtener la posición o índice de un elemento usando .indexOf(elemento)
 * se puede recorrer una lista usando un bucle for o un lambda
 * **/
//fun main() {
//    val solarSystem = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
//    println(solarSystem)
//    println(solarSystem.size)
//    println(solarSystem[2])
//    println(solarSystem.get(3))
//    println(solarSystem.indexOf("Earth"))
//    println(solarSystem.indexOf("Pluto"))
//    for (planet in solarSystem) {
//        println(planet)
//    }
//    solarSystem.forEach { planet -> println(planet) }
//}

/*
 * los arreglos son la estructura básica sin muchas funciones, no se recomienda
 * su uso general, sólo si es muy importante la gestión de memoria y velocidad
 * se prefiere el uso de las listas
 * los arreglos, una vez creados, son de longitud fija y no pueden recibir un
 * valor extra, si se quiere agregar un valor es necesario crear otro arreglo
 * **/
//fun main() {
//    val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars")
//    val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")
//    val solarSystem = rockPlanets + gasPlanets
//    solarSystem.forEach { p -> println(p) }
//    println()
//    println(solarSystem[4])
//    solarSystem[3] = "Little Earth"
//    solarSystem.forEach { p -> println(p) }
//
//    val newSolarSystem = arrayOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune", "Pluto")
//    newSolarSystem.forEach { p -> println(p) }
//}