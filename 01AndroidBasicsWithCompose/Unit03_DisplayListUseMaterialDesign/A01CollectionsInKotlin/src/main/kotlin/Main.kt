fun main() {
    val solarSystem = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")
    println(solarSystem)
    println(solarSystem.size)
    println(solarSystem[2])
    println(solarSystem.get(3))
}

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