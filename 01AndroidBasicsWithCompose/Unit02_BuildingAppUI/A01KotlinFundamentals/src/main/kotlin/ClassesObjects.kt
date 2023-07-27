
/*
 * Ejemplo sobre el uso de clases, curso de ANDROID BASICS WITH COMPOSE
 * es posible definir funciones dentro de las clases, estos métodos pueden
 * ser llamados desde los objetos, como se ve en el metodo main
 */

class SmartDevice {
    fun turnOn() {
        println("Smart device is turned on.")
    }

    fun turnOff() {
        println("Smart device is turned off.")
    }
}

fun main() {
    val smartTvDevice = SmartDevice()

    smartTvDevice.turnOn()
    smartTvDevice.turnOff()
}

///*
// * Ejemplo sobre el uso de clases, curso de ANDROID BASICS WITH COMPOSE
// * Las clases se pueden declarar usando la palabra reservada class y el
// * nombre de la clase, empezando en mayusculas
// * la instancia de una clase se puede hacer como se muestra en el método
// * main, solo basta con declarar una variable y asignarle el nombre de la
// * clase, como si se invocara al constructor directamente
// * es necesesario aclara que si bien estamos usando una variable de tipo
// * inmutable con val, el objeto en si mismo es mutable, esto es porque
// * val solo impide que se reasigne el valor de dicha variable pero no
// * afecta al objeto contenido en dicha variable
// */
//
//class SmartDevice {
//
//}
//
//fun main() {
//    val smartTvDevice = SmartDevice()
//}