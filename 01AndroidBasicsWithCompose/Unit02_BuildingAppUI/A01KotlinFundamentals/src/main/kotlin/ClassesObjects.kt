/*
 * Ejemplo sobre el uso de clases, curso de ANDROID BASICS WITH COMPOSE
 * HERENCIA, es posible generar otras clases usando como base la clase
 * definida (SmartDevice) para tener un smart TV, o una smart light
 * toda clase creada es una clase inmutable, es decir, es una clase tipo
 * final, para poder extender una clase es necesario indicarlo con la
 * palabra reservada open
 * en el cuerpo de la nueva clase es posible definir propiedades de esta
 * clase (speakerVolume) que no esten presentes en la clase padre
 * (SmartDevice)
 * además es posible definir más propiedades y metodos para ser usados por
 * los objetos instanciados de esta clase
 * relaciones es-un, tanto SmartTVDevice como SmartLightDevice 'son' del
 * tipo SmartDevice, lo contrario no es posible afirmarlo, esta condición
 * debe ser satisfecha y no se debe usar herencia sólo para reutilizar
 * código
 */

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {
    var brightnessLevel = 0
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increase to $brightnessLevel")
    }
}

class SmartTVDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {
    var speakerVolume = 2
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }
    var channelNumber = 1
        set(value) {
            if (value in 0..200) {
                field = value
            }
        }

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increase to $channelNumber")
    }
}

open class SmartDevice(val name: String = "Android TV", val category: String = "Entertainment") {
    var deviceStatus = "online"

    constructor(name: String, category: String, statusCode: Int) : this(name = name, category = category) {
        deviceStatus = when (statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }

    fun turnOn() {
        println("Smart device is turned on.")
    }

    fun turnOff() {
        println("Smart device is turned off.")
    }
}

fun main() {
    val smartTvDevice = SmartDevice()

    println("Device name is: ${smartTvDevice.name}")

    smartTvDevice.turnOn()
    smartTvDevice.turnOff()
}

///*
// * Ejemplo sobre el uso de clases, curso de ANDROID BASICS WITH COMPOSE
// * el constructor sin parametros es un constructor por default y no se
// * coloca de manera explicita porque es redundante, tiene la siguiente
// * forma:
// *     class SmartDevice constructor() {...
// * por eso no se coloca, mas bien se debe explicitar si se va a tener
// * un constructor con parametros, como se ve en la clase
// * toda clase debe tener un constructor primario, es el que se define
// * en la definicion de la case y no puede tener código asociado, este
// * puede ser uno parametrizado o sin parametros
// * una clase puede tener varios constructores secundarios, estos pueden
// * ser con o sin parametros y si pueden tener codigo asociado, además, si
// * la clase tiene un constructor primario, todos los constructores
// * secundarios debe inicializar el constructor primario
// */
//
//class SmartDevice (val name: String = "Android TV", val category: String = "Entertainment"){
//    var deviceStatus = "online"
//
//    /*
//     * en este caso se invca al metodo constructor principal usando el término
//     * this(name, category) y así se le manda los parametros necesarios para
//     * su ejecución y solo se procesa el valos de statusCode para la propiedad
//     * deviceStatus
//     * */
//    constructor(name: String, category: String, statusCode: Int) : this(name = name, category = category) {
//        deviceStatus = when (statusCode) {
//            0 -> "offline"
//            1 -> "online"
//            else -> "unknown"
//        }
//    }
//
//    fun turnOn() {
//        println("Smart device is turned on.")
//    }
//
//    fun turnOff() {
//        println("Smart device is turned off.")
//    }
//}
//
//fun main() {
//    val smartTvDevice = SmartDevice()
//
//    println("Device name is: ${smartTvDevice.name}")
//
//    smartTvDevice.turnOn()
//    smartTvDevice.turnOff()
//}

///*
// * Ejemplo sobre el uso de clases, curso de ANDROID BASICS WITH COMPOSE
// * para controlar los metodos get y set hay que tener en cuenta que las
// * variables mutables pueden tener ambos métodos, mientras que las variables
// * inmutables no requieren del método set en vista que su valor no puede
// * ser reasignado.
// * el valor field es usado para llevar el valor asignado a la propiedad
// * ya que esta se asigna de manera directa.
// * en el ejemplo el metodo set valida que el valor entrante (value) esté
// * en el rango de valores validos para speakerVolume (0..100)
// * además el método get de la propiedad name devuelve el valor en
// * mayúsculas
// */
//
//class SmartDevice {
//    val name = "Android TV"
//        get() = field.uppercase()
//    val category = "Enertainment"
//    var deviceStatus = "online"
//    var speakerVolume = 2
//        get() = field
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
//
//    fun turnOn() {
//        println("Smart device is turned on.")
//    }
//
//    fun turnOff() {
//        println("Smart device is turned off.")
//    }
//}
//
//fun main() {
//    val smartTvDevice = SmartDevice()
//
//    println("Device name is: ${smartTvDevice.name}")
//
//    smartTvDevice.turnOn()
//    smartTvDevice.turnOff()
//}

///*
// * Ejemplo sobre el uso de clases, curso de ANDROID BASICS WITH COMPOSE
// * en las clases es posible la definición de atributos, en este caso bajo
// * la forma de propiedades, las cuales pueden ser accedidas directamente
// * desde el exterior, basta con definirlas como variables, algunas inmutables
// * y otras mutables y se pueden acceder desde el exterior.
// */
//
//class SmartDevice {
//    val name = "Android TV"
//    val category = "Enertainment"
//    var deviceStatus = "online"
//
//    fun turnOn() {
//        println("Smart device is turned on.")
//    }
//
//    fun turnOff() {
//        println("Smart device is turned off.")
//    }
//}
//
//fun main() {
//    val smartTvDevice = SmartDevice()
//
//    println("Device name is: ${smartTvDevice.name}")
//
//    smartTvDevice.turnOn()
//    smartTvDevice.turnOff()
//}

///*
// * Ejemplo sobre el uso de clases, curso de ANDROID BASICS WITH COMPOSE
// * es posible definir funciones dentro de las clases, estos métodos pueden
// * ser llamados desde los objetos, como se ve en el metodo main
// */
//
//class SmartDevice {
//    fun turnOn() {
//        println("Smart device is turned on.")
//    }
//
//    fun turnOff() {
//        println("Smart device is turned off.")
//    }
//}
//
//fun main() {
//    val smartTvDevice = SmartDevice()
//
//    smartTvDevice.turnOn()
//    smartTvDevice.turnOff()
//}

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