
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/*
 * Ejemplo sobre el uso de clases, curso de ANDROID BASICS WITH COMPOSE
 * ahora a implementar el reto
 * - In the SmartDevice class, define a printDeviceInfo() method that prints a "Device name: $name, category: $category, type: $deviceType" string.
 * - In the SmartTvDevice class, define a decreaseVolume() method that decreases the volume and a previousChannel() method that navigates to the previous channel.
 * - In the SmartLightDevice class, define a decreaseBrightness() method that decreases the brightness.
 * - In the SmartHome class, ensure that all actions can only be performed when each device's deviceStatus property is set to an "on" string. Also, ensure that the deviceTurnOnCount property is updated correctly.
 * After you're done with the implementation:
 * - In the SmartHome class, define an decreaseTvVolume(), changeTvChannelToPrevious(), printSmartTvInfo(), printSmartLightInfo(), and decreaseLightBrightness() method.
 * - Call the appropriate methods from the SmartTvDevice and SmartLightDevice classes in the SmartHome class.
 * - In the main() function, call these added methods to test them.
 *
 * implementación completa, finalizado el tema
 */

class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {
    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}

fun main() {
    val smartHome = SmartHome(
        SmartTvDevice(deviceName = "Android TV", deviceCategory = "Entertainment"),
        SmartLightDevice(deviceName = "Google light", deviceCategory = "Utility")
    )

    smartHome.printSmartTvInfo()
    smartHome.printSmartLightInfo()
    println()

    smartHome.increaseTvVolume()
    smartHome.changeTvChannelToNext()
    smartHome.increaseLightBrightness()
    println()

    smartHome.turnOnTv()
    smartHome.turnOnTv()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")
    println()


    smartHome.turnOnLight()
    smartHome.turnOnLight()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")
    println()

    smartHome.increaseTvVolume()
    smartHome.increaseTvVolume()
    smartHome.increaseTvVolume()
    smartHome.decreaseTvVolume()
    smartHome.decreaseTvVolume()
    smartHome.changeTvChannelToNext()
    smartHome.changeTvChannelToNext()
    smartHome.changeTvChannelToNext()
    smartHome.changeTvChannelToPrevious()
    smartHome.increaseLightBrightness()
    smartHome.increaseLightBrightness()
    smartHome.increaseLightBrightness()
    smartHome.increaseLightBrightness()
    smartHome.decreaseLightBrightness()
    println()

    smartHome.turnOffAllDevices()
    smartHome.turnOffAllDevices()
    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")
}

class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {
    var deviceTurnOnCount = 0
        private set

    fun turnOnTv() {
        if (!smartTvDevice.isOn()) {
            smartTvDevice.turnOn()
            deviceTurnOnCount++
        } else {
            println("${smartTvDevice.name} isn't off, can't turned on.")
        }
    }

    fun turnOffTv() {
        if (smartTvDevice.isOn()) {
            smartTvDevice.turnOff()
            deviceTurnOnCount--
        } else {
            println("${smartTvDevice.name} isn't on, can't turned off.")
        }
    }

    fun increaseTvVolume() {
        if (smartTvDevice.isOn()) {
            smartTvDevice.increaseSpeakerVolume()
        } else {
            println("${smartTvDevice.name} isn't on, can't operate it.")
        }
    }

    fun decreaseTvVolume() {
        if (smartTvDevice.isOn()) {
            smartTvDevice.decreaseSpeakerVolume()
        } else {
            println("${smartTvDevice.name} isn't on, can't operate it.")
        }
    }

    fun changeTvChannelToNext() {
        if (smartTvDevice.isOn()) {
            smartTvDevice.nextChannel()
        } else {
            println("${smartTvDevice.name} isn't on, can't operate it.")
        }
    }

    fun changeTvChannelToPrevious() {
        if (smartTvDevice.isOn()) {
            smartTvDevice.previousChannel()
        } else {
            println("${smartTvDevice.name} isn't on, can't operate it.")
        }
    }

    fun printSmartTvInfo() {
        smartTvDevice.printDeviceInfo()
    }

    fun printSmartLightInfo() {
        smartLightDevice.printDeviceInfo()
    }

    fun turnOnLight() {
        if (!smartLightDevice.isOn()) {
            smartLightDevice.turnOn()
            deviceTurnOnCount++
        } else {
            println("${smartLightDevice.name} isn't off, can't turned on.")
        }
    }

    fun turnOffLight() {
        if (smartLightDevice.isOn()) {
            smartLightDevice.turnOff()
            deviceTurnOnCount--
        } else {
            println("${smartLightDevice.name} isn't on, can't operate it.")
        }
    }

    fun increaseLightBrightness() {
        if (smartLightDevice.isOn()) {
            smartLightDevice.increaseBrightness()
        } else {
            println("${smartLightDevice.name} isn't on, can't operate it.")
        }
    }

    fun decreaseLightBrightness() {
        if (smartLightDevice.isOn()) {
            smartLightDevice.decreaseBrightness()
        } else {
            println("${smartLightDevice.name} isn't on, can't operate it.")
        }
    }

    fun turnOffAllDevices() {
        turnOffLight()
        turnOffTv()
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {
    override val deviceType = "Smart Light"
    private var brightnessLevel by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("$name turned off.")
    }

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increase to $brightnessLevel")
    }

    fun decreaseBrightness() {
        brightnessLevel--
        println("Brightness decrease to $brightnessLevel")
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {
    override val deviceType = "Smart TV"
    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is set to " +
                    "$channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name is turned off.")
    }

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume")
    }

    fun decreaseSpeakerVolume() {
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increase to $channelNumber")
    }

    fun previousChannel() {
        channelNumber--
        println("Channel number decrease to $channelNumber")
    }
}

open class SmartDevice(val name: String = "Android TV", val category: String = "Entertainment") {
    var deviceStatus = "off"
        protected set
    open val deviceType = "unknown"

    constructor(name: String, category: String, statusCode: Int) : this(name = name, category = category) {
        deviceStatus = when (statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }

    open fun turnOn() {
        deviceStatus = "on"
    }

    open fun turnOff() {
        deviceStatus = "off"
    }

    fun printDeviceInfo() {
        println("Device name: $name, category: $category, type: $deviceType")
    }

    fun isOn(): Boolean{
        return deviceStatus.equals("on")
    }
}

//import kotlin.properties.ReadWriteProperty
//import kotlin.reflect.KProperty
//
///*
// * Ejemplo sobre el uso de clases, curso de ANDROID BASICS WITH COMPOSE
// * es hora de probar la solución, revise el código en la función main para
// * comprobar que se están ejecutando las cosas como se debe
// * PROYECTO VERIFICADO... listo para el reto
// */
//
//class RangeRegulator(
//    initialValue: Int,
//    private val minValue: Int,
//    private val maxValue: Int
//) : ReadWriteProperty<Any?, Int> {
//    var fieldData = initialValue
//
//    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
//        return fieldData
//    }
//
//    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
//        if (value in minValue..maxValue) {
//            fieldData = value
//        }
//    }
//}
//
//fun main() {
//    val smartHome = SmartHome(
//        SmartTvDevice(deviceName = "Android TV", deviceCategory = "Entertainment"),
//        SmartLightDevice(deviceName = "Google light", deviceCategory = "Utility")
//    )
//    smartHome.turnOnTv()
//    smartHome.turnOnLight()
//    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")
//    println()
//
//    smartHome.increaseTvVolume()
//    smartHome.changeTvChannelToNext()
//    smartHome.increaseLightBrightness()
//    println()
//
//    smartHome.turnOffAllDevices()
//    println("Total number of devices currently turned on: ${smartHome.deviceTurnOnCount}")
//}
//
//class SmartHome(
//    val smartTvDevice: SmartTvDevice,
//    val smartLightDevice: SmartLightDevice
//) {
//    var deviceTurnOnCount = 0
//        private set
//
//    fun turnOnTv() {
//        smartTvDevice.turnOn()
//        deviceTurnOnCount++
//    }
//
//    fun turnOffTv() {
//        smartTvDevice.turnOff()
//        deviceTurnOnCount--
//    }
//
//    fun increaseTvVolume() {
//        smartTvDevice.increaseSpeakerVolume()
//    }
//
//    fun changeTvChannelToNext() {
//        smartTvDevice.nextChannel()
//    }
//
//    fun turnOnLight() {
//        smartLightDevice.turnOn()
//        deviceTurnOnCount++
//    }
//
//    fun turnOffLight() {
//        smartLightDevice.turnOff()
//        deviceTurnOnCount--
//    }
//
//    fun increaseLightBrightness() {
//        smartLightDevice.increaseBrightness()
//    }
//
//    fun turnOffAllDevices() {
//        turnOffLight()
//        turnOffTv()
//    }
//}
//
//class SmartLightDevice(deviceName: String, deviceCategory: String) :
//    SmartDevice(name = deviceName, category = deviceCategory) {
//    override val deviceType = "Smart Light"
//    private var brightnessLevel by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)
//
//    override fun turnOn() {
//        super.turnOn()
//        brightnessLevel = 2
//        println("$name turned on. The brightness level is $brightnessLevel")
//    }
//
//    override fun turnOff() {
//        super.turnOff()
//        brightnessLevel = 0
//        println("$name turned off.")
//    }
//
//    fun increaseBrightness() {
//        brightnessLevel++
//        println("Brightness increase to $brightnessLevel")
//    }
//}
//
//class SmartTvDevice(deviceName: String, deviceCategory: String) :
//    SmartDevice(name = deviceName, category = deviceCategory) {
//    override val deviceType = "Smart TV"
//    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)
//    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)
//
//    override fun turnOn() {
//        super.turnOn()
//        println(
//            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is set to " +
//                    "$channelNumber."
//        )
//    }
//
//    override fun turnOff() {
//        super.turnOff()
//        println("$name is turned off.")
//    }
//
//    fun increaseSpeakerVolume() {
//        speakerVolume++
//        println("Speaker volume increased to $speakerVolume")
//    }
//
//    fun nextChannel() {
//        channelNumber++
//        println("Channel number increase to $channelNumber")
//    }
//}
//
//open class SmartDevice(val name: String = "Android TV", val category: String = "Entertainment") {
//    var deviceStatus = "online"
//        protected set
//    open val deviceType = "unknown"
//
//    constructor(name: String, category: String, statusCode: Int) : this(name = name, category = category) {
//        deviceStatus = when (statusCode) {
//            0 -> "offline"
//            1 -> "online"
//            else -> "unknown"
//        }
//    }
//
//    open fun turnOn() {
//        deviceStatus = "on"
//    }
//
//    open fun turnOff() {
//        deviceStatus = "off"
//    }
//}

//import kotlin.properties.ReadWriteProperty
//import kotlin.reflect.KProperty
//
///*
// * Ejemplo sobre el uso de clases, curso de ANDROID BASICS WITH COMPOSE
// * es hora de implementar la clase RangeRegulator, en la clase SmartTvDevice
// * podemos ahora definir lo siguiente
// *     private var speakerVolume by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)
// *     private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)
// * de esta forma se establece que el valor inicial de speakerVolume es 0 y
// * los limites que puede tomar su valor, igual para channelNumbre,
// * tambien se puede usar esta clase en la clase SmartLightDevice
// *     private var brightnessLevel by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)
// * de esta forma se puede usar una sola lógica para el control de los valores
// * de las propiedades, usando una clase que implementa una interfaz y
// * agregandola a las propiedades declaradas, esto es propiedades delegadas
// */
//
//class RangeRegulator(
//    initialValue: Int,
//    private val minValue: Int,
//    private val maxValue: Int
//) : ReadWriteProperty<Any?, Int> {
//    var fieldData = initialValue
//
//    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
//        return fieldData
//    }
//
//    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
//        if (value in minValue..maxValue) {
//            fieldData = value
//        }
//    }
//}
//
//fun main() {
//    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
//    smartDevice.turnOn()
//
//    smartDevice = SmartLightDevice("Google Light", "Utility")
//    smartDevice.turnOn()
//}
//
//class SmartHome(
//    val smartTvDevice: SmartTvDevice,
//    val smartLightDevice: SmartLightDevice
//) {
//    var deviceTurnOnCount = 0
//        private set
//
//    fun turnOnTv() {
//        smartTvDevice.turnOn()
//        deviceTurnOnCount++
//    }
//
//    fun turnOffTv() {
//        smartTvDevice.turnOff()
//        deviceTurnOnCount--
//    }
//
//    fun increaseTvVolume() {
//        smartTvDevice.increaseSpeakerVolume()
//    }
//
//    fun changeTvChannelToNext() {
//        smartTvDevice.nextChannel()
//    }
//
//    fun turnOnLight() {
//        smartLightDevice.turnOn()
//        deviceTurnOnCount++
//    }
//
//    fun turnOffLight() {
//        smartLightDevice.turnOff()
//        deviceTurnOnCount--
//    }
//
//    fun increaseLightBrightness() {
//        smartLightDevice.increaseBrightness()
//    }
//
//    fun turnOffAllDevices() {
//        smartLightDevice.turnOff()
//        smartTvDevice.turnOff()
//    }
//}
//
//class SmartLightDevice(deviceName: String, deviceCategory: String) :
//    SmartDevice(name = deviceName, category = deviceCategory) {
//    override val deviceType = "Smart Light"
//    private var brightnessLevel by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)
//
//    override fun turnOn() {
//        super.turnOn()
//        brightnessLevel = 2
//        println("$name turned on. The brightness level is $brightnessLevel")
//    }
//
//    override fun turnOff() {
//        super.turnOff()
//        brightnessLevel = 0
//        println("$name turned off.")
//    }
//
//    fun increaseBrightness() {
//        brightnessLevel++
//        println("Brightness increase to $brightnessLevel")
//    }
//}
//
//class SmartTvDevice(deviceName: String, deviceCategory: String) :
//    SmartDevice(name = deviceName, category = deviceCategory) {
//    override val deviceType = "Smart TV"
//    private var speakerVolume by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)
//    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)
//
//    override fun turnOn() {
//        super.turnOn()
//        println(
//            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is set to " +
//                    "$channelNumber."
//        )
//    }
//
//    override fun turnOff() {
//        super.turnOff()
//        println("$name is turned off.")
//    }
//
//    fun increaseSpeakerVolume() {
//        speakerVolume++
//        println("Speaker volume increased to $speakerVolume")
//    }
//
//    fun nextChannel() {
//        channelNumber++
//        println("Channel number increase to $channelNumber")
//    }
//}
//
//open class SmartDevice(val name: String = "Android TV", val category: String = "Entertainment") {
//    var deviceStatus = "online"
//        protected set
//    open val deviceType = "unknown"
//
//    constructor(name: String, category: String, statusCode: Int) : this(name = name, category = category) {
//        deviceStatus = when (statusCode) {
//            0 -> "offline"
//            1 -> "online"
//            else -> "unknown"
//        }
//    }
//
//    open fun turnOn() {
//        deviceStatus = "on"
//    }
//
//    open fun turnOff() {
//        deviceStatus = "off"
//    }
//}

//import kotlin.properties.ReadWriteProperty
//import kotlin.reflect.KProperty
//
///*
// * Ejemplo sobre el uso de clases, curso de ANDROID BASICS WITH COMPOSE
// * una interfaz es una relación de requerimientos que deben ser implementados
// * por aquellos que implementen la interfaz, es como cuando vamos a construir
// * una casa y antes definimos que se necesitan dos baños, tres dormitorios
// * una sala comedor y una cocina, es el arquitecto el que va a ver la forma
// * de implementar el requerimiento, pero el requerimiento existe en forma de
// * interfaz
// * ahora vamos a usar una clase que usa la interfaz ReadWriteProperty y controlar
// * el ingreso de datos en algunas propiedades
// * la clase RangeRegulator implementa la interfaz ReadWriteProperty, además en su
// * constructor principal recibe tres valores, el valor inicial y el minimo y
// * maximo para validación
// * es recien ahora que aparecen dos imports
// *     import kotlin.properties.ReadWriteProperty
// *     import kotlin.reflect.KProperty
// * con la implementación actual es posible controlar el ingreso de valores por
// * rango
// */
//
//class RangeRegulator(
//    initialValue: Int,
//    private val minValue: Int,
//    private val maxValue: Int
//) : ReadWriteProperty<Any?, Int> {
//    var fieldData = initialValue
//
//    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
//        return fieldData
//    }
//
//    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
//        if (value in minValue..maxValue) {
//            fieldData = value
//        }
//    }
//}
//
//fun main() {
//    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
//    smartDevice.turnOn()
//
//    smartDevice = SmartLightDevice("Google Light", "Utility")
//    smartDevice.turnOn()
//}
//
//class SmartHome(
//    val smartTvDevice: SmartTvDevice,
//    val smartLightDevice: SmartLightDevice
//) {
//    var deviceTurnOnCount = 0
//        private set
//
//    fun turnOnTv() {
//        smartTvDevice.turnOn()
//        deviceTurnOnCount++
//    }
//
//    fun turnOffTv() {
//        smartTvDevice.turnOff()
//        deviceTurnOnCount--
//    }
//
//    fun increaseTvVolume() {
//        smartTvDevice.increaseSpeakerVolume()
//    }
//
//    fun changeTvChannelToNext() {
//        smartTvDevice.nextChannel()
//    }
//
//    fun turnOnLight() {
//        smartLightDevice.turnOn()
//        deviceTurnOnCount++
//    }
//
//    fun turnOffLight() {
//        smartLightDevice.turnOff()
//        deviceTurnOnCount--
//    }
//
//    fun increaseLightBrightness() {
//        smartLightDevice.increaseBrightness()
//    }
//
//    fun turnOffAllDevices() {
//        smartLightDevice.turnOff()
//        smartTvDevice.turnOff()
//    }
//}
//
//class SmartLightDevice(deviceName: String, deviceCategory: String) :
//    SmartDevice(name = deviceName, category = deviceCategory) {
//    override val deviceType = "Smart Light"
//    private var brightnessLevel = 0
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
//
//    override fun turnOn() {
//        super.turnOn()
//        brightnessLevel = 2
//        println("$name turned on. The brightness level is $brightnessLevel")
//    }
//
//    override fun turnOff() {
//        super.turnOff()
//        brightnessLevel = 0
//        println("$name turned off.")
//    }
//
//    fun increaseBrightness() {
//        brightnessLevel++
//        println("Brightness increase to $brightnessLevel")
//    }
//}
//
//class SmartTvDevice(deviceName: String, deviceCategory: String) :
//    SmartDevice(name = deviceName, category = deviceCategory) {
//    override val deviceType = "Smart TV"
//    private var speakerVolume = 2
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
//    private var channelNumber = 1
//        set(value) {
//            if (value in 0..200) {
//                field = value
//            }
//        }
//
//    override fun turnOn() {
//        super.turnOn()
//        println(
//            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is set to " +
//                    "$channelNumber."
//        )
//    }
//
//    override fun turnOff() {
//        super.turnOff()
//        println("$name is turned off.")
//    }
//
//    fun increaseSpeakerVolume() {
//        speakerVolume++
//        println("Speaker volume increased to $speakerVolume")
//    }
//
//    fun nextChannel() {
//        channelNumber++
//        println("Channel number increase to $channelNumber")
//    }
//}
//
//open class SmartDevice(val name: String = "Android TV", val category: String = "Entertainment") {
//    var deviceStatus = "online"
//        protected set
//    open val deviceType = "unknown"
//
//    constructor(name: String, category: String, statusCode: Int) : this(name = name, category = category) {
//        deviceStatus = when (statusCode) {
//            0 -> "offline"
//            1 -> "online"
//            else -> "unknown"
//        }
//    }
//
//    open fun turnOn() {
//        deviceStatus = "on"
//    }
//
//    open fun turnOff() {
//        deviceStatus = "off"
//    }
//}

///*
// * Ejemplo sobre el uso de clases, curso de ANDROID BASICS WITH COMPOSE
// * atributos como speakerVolume y channelNumber en SmartTvDevice deben
// * ser privados ya que no se deben modificar desde el exterior
// * igual con brightnessLevel en SmartLightDevice
// */
//
//fun main() {
//    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
//    smartDevice.turnOn()
//
//    smartDevice = SmartLightDevice("Google Light", "Utility")
//    smartDevice.turnOn()
//}
//
//class SmartHome(
//    val smartTvDevice: SmartTvDevice,
//    val smartLightDevice: SmartLightDevice
//) {
//    var deviceTurnOnCount = 0
//        private set
//
//    fun turnOnTv() {
//        smartTvDevice.turnOn()
//        deviceTurnOnCount++
//    }
//
//    fun turnOffTv() {
//        smartTvDevice.turnOff()
//        deviceTurnOnCount--
//    }
//
//    fun increaseTvVolume() {
//        smartTvDevice.increaseSpeakerVolume()
//    }
//
//    fun changeTvChannelToNext() {
//        smartTvDevice.nextChannel()
//    }
//
//    fun turnOnLight() {
//        smartLightDevice.turnOn()
//        deviceTurnOnCount++
//    }
//
//    fun turnOffLight() {
//        smartLightDevice.turnOff()
//        deviceTurnOnCount--
//    }
//
//    fun increaseLightBrightness() {
//        smartLightDevice.increaseBrightness()
//    }
//
//    fun turnOffAllDevices() {
//        smartLightDevice.turnOff()
//        smartTvDevice.turnOff()
//    }
//}
//
//class SmartLightDevice(deviceName: String, deviceCategory: String) :
//    SmartDevice(name = deviceName, category = deviceCategory) {
//    override val deviceType = "Smart Light"
//    private var brightnessLevel = 0
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
//
//    override fun turnOn() {
//        super.turnOn()
//        brightnessLevel = 2
//        println("$name turned on. The brightness level is $brightnessLevel")
//    }
//
//    override fun turnOff() {
//        super.turnOff()
//        brightnessLevel = 0
//        println("$name turned off.")
//    }
//
//    fun increaseBrightness() {
//        brightnessLevel++
//        println("Brightness increase to $brightnessLevel")
//    }
//}
//
//class SmartTvDevice(deviceName: String, deviceCategory: String) :
//    SmartDevice(name = deviceName, category = deviceCategory) {
//    override val deviceType = "Smart TV"
//    private var speakerVolume = 2
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
//    private var channelNumber = 1
//        set(value) {
//            if (value in 0..200) {
//                field = value
//            }
//        }
//
//    override fun turnOn() {
//        super.turnOn()
//        println(
//            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is set to " +
//                    "$channelNumber."
//        )
//    }
//
//    override fun turnOff() {
//        super.turnOff()
//        println("$name is turned off.")
//    }
//
//    fun increaseSpeakerVolume() {
//        speakerVolume++
//        println("Speaker volume increased to $speakerVolume")
//    }
//
//    fun nextChannel() {
//        channelNumber++
//        println("Channel number increase to $channelNumber")
//    }
//}
//
//open class SmartDevice(val name: String = "Android TV", val category: String = "Entertainment") {
//    var deviceStatus = "online"
//        protected set
//    open val deviceType = "unknown"
//
//    constructor(name: String, category: String, statusCode: Int) : this(name = name, category = category) {
//        deviceStatus = when (statusCode) {
//            0 -> "offline"
//            1 -> "online"
//            else -> "unknown"
//        }
//    }
//
//    open fun turnOn() {
//        deviceStatus = "on"
//    }
//
//    open fun turnOff() {
//        deviceStatus = "off"
//    }
//}

///*
// * Ejemplo sobre el uso de clases, curso de ANDROID BASICS WITH COMPOSE
// * la visibilidad de los modificadore para los métodos se puede controlar
// * con la siguiente sintaxis
// *     protected fun nextChannel() { ...
// * ahora el método nextChannel solo se puede acceder desde las subclases
// * de SmartTvDevice, esto provoca un error por el acceso usado desde la
// * clase SmartHome
// * tambien es posible controlar el nivel de acceso de los constructores
// *     open class SmartDevice protected constructor(val name: String ...
// * esto sólo permite el uso del constructor principal con parametros
// * desde las clases hijos
// * finalmente tambien es posible controlar el nivel de acceso de las clases
// * completas
// *     internal open class SmartDevice(val name: String
// * precediendo el nivel de acceso como primer término en la declaración
// * de la clase, incluso antes de la palabra reservada 'open'
// * se recomienda una asignación restrictiva a todos los elementos, es decir,
// * declarar todos private, si no puede ser private entonces es protected, si
// * no se puede con protected entonces es internal y si no, finalmente optar
// * por public.
// */
//
//fun main() {
//    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
//    smartDevice.turnOn()
//
//    smartDevice = SmartLightDevice("Google Light", "Utility")
//    smartDevice.turnOn()
//}
//
//class SmartHome(
//    val smartTvDevice: SmartTvDevice,
//    val smartLightDevice: SmartLightDevice
//) {
//    var deviceTurnOnCount = 0
//        private set
//
//    fun turnOnTv() {
//        smartTvDevice.turnOn()
//        deviceTurnOnCount++
//    }
//
//    fun turnOffTv() {
//        smartTvDevice.turnOff()
//        deviceTurnOnCount--
//    }
//
//    fun increaseTvVolume() {
//        smartTvDevice.increaseSpeakerVolume()
//    }
//
//    fun changeTvChannelToNext() {
//        smartTvDevice.nextChannel()
//    }
//
//    fun turnOnLight() {
//        smartLightDevice.turnOn()
//        deviceTurnOnCount++
//    }
//
//    fun turnOffLight() {
//        smartLightDevice.turnOff()
//        deviceTurnOnCount--
//    }
//
//    fun increaseLightBrightness() {
//        smartLightDevice.increaseBrightness()
//    }
//
//    fun turnOffAllDevices() {
//        smartLightDevice.turnOff()
//        smartTvDevice.turnOff()
//    }
//}
//
//class SmartLightDevice(deviceName: String, deviceCategory: String) :
//    SmartDevice(name = deviceName, category = deviceCategory) {
//    override val deviceType = "Smart Light"
//    var brightnessLevel = 0
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
//
//    override fun turnOn() {
//        super.turnOn()
//        brightnessLevel = 2
//        println("$name turned on. The brightness level is $brightnessLevel")
//    }
//
//    override fun turnOff() {
//        super.turnOff()
//        brightnessLevel = 0
//        println("$name turned off.")
//    }
//
//    fun increaseBrightness() {
//        brightnessLevel++
//        println("Brightness increase to $brightnessLevel")
//    }
//}
//
//class SmartTvDevice(deviceName: String, deviceCategory: String) :
//    SmartDevice(name = deviceName, category = deviceCategory) {
//    override val deviceType = "Smart TV"
//    var speakerVolume = 2
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
//    var channelNumber = 1
//        set(value) {
//            if (value in 0..200) {
//                field = value
//            }
//        }
//
//    override fun turnOn() {
//        super.turnOn()
//        println(
//            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is set to " +
//                    "$channelNumber."
//        )
//    }
//
//    override fun turnOff() {
//        super.turnOff()
//        println("$name is turned off.")
//    }
//
//    fun increaseSpeakerVolume() {
//        speakerVolume++
//        println("Speaker volume increased to $speakerVolume")
//    }
//
//    fun nextChannel() {
//        channelNumber++
//        println("Channel number increase to $channelNumber")
//    }
//}
//
//open class SmartDevice(val name: String = "Android TV", val category: String = "Entertainment") {
//    var deviceStatus = "online"
//        protected set
//    open val deviceType = "unknown"
//
//    constructor(name: String, category: String, statusCode: Int) : this(name = name, category = category) {
//        deviceStatus = when (statusCode) {
//            0 -> "offline"
//            1 -> "online"
//            else -> "unknown"
//        }
//    }
//
//    open fun turnOn() {
//        deviceStatus = "on"
//    }
//
//    open fun turnOff() {
//        deviceStatus = "off"
//    }
//}

///*
// * Ejemplo sobre el uso de clases, curso de ANDROID BASICS WITH COMPOSE
// * ahora en la clase SmartHome vamos a poner una propiedad deviceTurnOnCount
// * con un modificador set privado, es decir, es de solo lectura desde el
// * exterior, de la siguiente forma:
// *     var deviceTurnOnCount = 0
// *         private set
// * y agregamos los incrementos y decrementos en los respectivos métodos que
// * encienden y apagan los diferentes elementos de SmartHome
// */
//
//fun main() {
//    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
//    smartDevice.turnOn()
//
//    smartDevice = SmartLightDevice("Google Light", "Utility")
//    smartDevice.turnOn()
//}
//
//class SmartHome(
//    val smartTvDevice: SmartTvDevice,
//    val smartLightDevice: SmartLightDevice
//) {
//    var deviceTurnOnCount = 0
//        private set
//
//    fun turnOnTv() {
//        smartTvDevice.turnOn()
//        deviceTurnOnCount++
//    }
//
//    fun turnOffTv() {
//        smartTvDevice.turnOff()
//        deviceTurnOnCount--
//    }
//
//    fun increaseTvVolume() {
//        smartTvDevice.increaseSpeakerVolume()
//    }
//
//    fun changeTvChannelToNext() {
//        smartTvDevice.nextChannel()
//    }
//
//    fun turnOnLight() {
//        smartLightDevice.turnOn()
//        deviceTurnOnCount++
//    }
//
//    fun turnOffLight() {
//        smartLightDevice.turnOff()
//        deviceTurnOnCount--
//    }
//
//    fun increaseLightBrightness() {
//        smartLightDevice.increaseBrightness()
//    }
//
//    fun turnOffAllDevices() {
//        smartLightDevice.turnOff()
//        smartTvDevice.turnOff()
//    }
//}
//
//class SmartLightDevice(deviceName: String, deviceCategory: String) :
//    SmartDevice(name = deviceName, category = deviceCategory) {
//    override val deviceType = "Smart Light"
//    var brightnessLevel = 0
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
//
//    override fun turnOn() {
//        super.turnOn()
//        brightnessLevel = 2
//        println("$name turned on. The brightness level is $brightnessLevel")
//    }
//
//    override fun turnOff() {
//        super.turnOff()
//        brightnessLevel = 0
//        println("$name turned off.")
//    }
//
//    fun increaseBrightness() {
//        brightnessLevel++
//        println("Brightness increase to $brightnessLevel")
//    }
//}
//
//class SmartTvDevice(deviceName: String, deviceCategory: String) :
//    SmartDevice(name = deviceName, category = deviceCategory) {
//    override val deviceType = "Smart TV"
//    var speakerVolume = 2
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
//    var channelNumber = 1
//        set(value) {
//            if (value in 0..200) {
//                field = value
//            }
//        }
//
//    override fun turnOn() {
//        super.turnOn()
//        println(
//            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is set to " +
//                    "$channelNumber."
//        )
//    }
//
//    override fun turnOff() {
//        super.turnOff()
//        println("$name is turned off.")
//    }
//
//    fun increaseSpeakerVolume() {
//        speakerVolume++
//        println("Speaker volume increased to $speakerVolume")
//    }
//
//    fun nextChannel() {
//        channelNumber++
//        println("Channel number increase to $channelNumber")
//    }
//}
//
//open class SmartDevice(val name: String = "Android TV", val category: String = "Entertainment") {
//    var deviceStatus = "online"
//        protected set
//    open val deviceType = "unknown"
//
//    constructor(name: String, category: String, statusCode: Int) : this(name = name, category = category) {
//        deviceStatus = when (statusCode) {
//            0 -> "offline"
//            1 -> "online"
//            else -> "unknown"
//        }
//    }
//
//    open fun turnOn() {
//        deviceStatus = "on"
//    }
//
//    open fun turnOff() {
//        deviceStatus = "off"
//    }
//}

///*
// * Ejemplo sobre el uso de clases, curso de ANDROID BASICS WITH COMPOSE
// * modificadores de acceso, existen cuatro:
// *   public - visibilidad por default, se ve desde cualquier lado
// *   private - solo se ve desde la misma clase o archivo de código fuente
// *   protected - se ve desde la clase y las subclases
// *   internal - se ve desde el mismo módulo, es similar a private pero
// *              se permite el acceso a los elementos en el mismo modulo
// * un módulo es una coleccion de archivos de código fuente usados para poder
// * dividir el código en unidades pequeñas
// * un paquete es un directorio o folder donde se agrupan clases relacionadas
// * un módulo puede contener muchos paquetes
// * por ejemplo, en la clase SmartDevice
// *     private var deviceStatus = "online"
// * es posible poner como acceso privado a la propiedad deviceStatus, o controlar
// * sólo el acceso al método set, en este caso se tiene
// *     var deviceStatus = "online"
// *         protected set(value) {
// *             field = value
// *         }
// * si no se lleva a cabo ninguna operación de verificación como en el caso anterior
// * basta poner el código siguiente
// *     var deviceStatus = "online"
// *         protected set
// */
//
//fun main() {
//    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
//    smartDevice.turnOn()
//
//    smartDevice = SmartLightDevice("Google Light", "Utility")
//    smartDevice.turnOn()
//}
//
//class SmartHome(
//    val smartTvDevice: SmartTvDevice,
//    val smartLightDevice: SmartLightDevice
//) {
//    fun turnOnTv() {
//        smartTvDevice.turnOn()
//    }
//
//    fun turnOffTv() {
//        smartTvDevice.turnOff()
//    }
//
//    fun increaseTvVolume() {
//        smartTvDevice.increaseSpeakerVolume()
//    }
//
//    fun changeTvChannelToNext() {
//        smartTvDevice.nextChannel()
//    }
//
//    fun turnOnLight() {
//        smartLightDevice.turnOn()
//    }
//
//    fun turnOffLight() {
//        smartLightDevice.turnOff()
//    }
//
//    fun increaseLightBrightness() {
//        smartLightDevice.increaseBrightness()
//    }
//
//    fun turnOffAllDevices() {
//        smartLightDevice.turnOff()
//        smartTvDevice.turnOff()
//    }
//}
//
//class SmartLightDevice(deviceName: String, deviceCategory: String) :
//    SmartDevice(name = deviceName, category = deviceCategory) {
//    override val deviceType = "Smart Light"
//    var brightnessLevel = 0
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
//
//    override fun turnOn() {
//        super.turnOn()
//        brightnessLevel = 2
//        println("$name turned on. The brightness level is $brightnessLevel")
//    }
//
//    override fun turnOff() {
//        super.turnOff()
//        brightnessLevel = 0
//        println("$name turned off.")
//    }
//
//    fun increaseBrightness() {
//        brightnessLevel++
//        println("Brightness increase to $brightnessLevel")
//    }
//}
//
//class SmartTvDevice(deviceName: String, deviceCategory: String) :
//    SmartDevice(name = deviceName, category = deviceCategory) {
//    override val deviceType = "Smart TV"
//    var speakerVolume = 2
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
//    var channelNumber = 1
//        set(value) {
//            if (value in 0..200) {
//                field = value
//            }
//        }
//
//    override fun turnOn() {
//        super.turnOn()
//        println("$name is turned on. Speaker volume is set to $speakerVolume and channel number is set to " +
//                "$channelNumber.")
//    }
//
//    override fun turnOff() {
//        super.turnOff()
//        println("$name is turned off.")
//    }
//
//    fun increaseSpeakerVolume() {
//        speakerVolume++
//        println("Speaker volume increased to $speakerVolume")
//    }
//
//    fun nextChannel() {
//        channelNumber++
//        println("Channel number increase to $channelNumber")
//    }
//}
//
//open class SmartDevice(val name: String = "Android TV", val category: String = "Entertainment") {
//    var deviceStatus = "online"
//        protected set
//    open val deviceType = "unknown"
//
//    constructor(name: String, category: String, statusCode: Int) : this(name = name, category = category) {
//        deviceStatus = when (statusCode) {
//            0 -> "offline"
//            1 -> "online"
//            else -> "unknown"
//        }
//    }
//
//    open fun turnOn() {
//        deviceStatus = "on"
//    }
//
//    open fun turnOff() {
//        deviceStatus = "off"
//    }
//}

///*
// * Ejemplo sobre el uso de clases, curso de ANDROID BASICS WITH COMPOSE
// * tambien es posible sobreescribir una variable definida en el padre,
// * para ello es necesario abrirla con 'open'
// * por ejemplo, creamos una variable en el padre
// *     open val deviceType = "unknown"
// * y ahora la usamos desde los hijos sobreescribiendola
// *     override val deviceType = "Smart TV"
// *     override val deviceType = "Smart Light"
// * cada linea en su respectiva clase, en SmartTvDevice y en SmartLightDevice
// */
//
//fun main() {
//    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
//    smartDevice.turnOn()
//
//    smartDevice = SmartLightDevice("Google Light", "Utility")
//    smartDevice.turnOn()
//}
//
//class SmartHome(
//    val smartTvDevice: SmartTvDevice,
//    val smartLightDevice: SmartLightDevice
//) {
//    fun turnOnTv() {
//        smartTvDevice.turnOn()
//    }
//
//    fun turnOffTv() {
//        smartTvDevice.turnOff()
//    }
//
//    fun increaseTvVolume() {
//        smartTvDevice.increaseSpeakerVolume()
//    }
//
//    fun changeTvChannelToNext() {
//        smartTvDevice.nextChannel()
//    }
//
//    fun turnOnLight() {
//        smartLightDevice.turnOn()
//    }
//
//    fun turnOffLight() {
//        smartLightDevice.turnOff()
//    }
//
//    fun increaseLightBrightness() {
//        smartLightDevice.increaseBrightness()
//    }
//
//    fun turnOffAllDevices() {
//        smartLightDevice.turnOff()
//        smartTvDevice.turnOff()
//    }
//}
//
//class SmartLightDevice(deviceName: String, deviceCategory: String) :
//    SmartDevice(name = deviceName, category = deviceCategory) {
//    override val deviceType = "Smart Light"
//    var brightnessLevel = 0
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
//
//    override fun turnOn() {
//        super.turnOn()
//        brightnessLevel = 2
//        println("$name turned on. The brightness level is $brightnessLevel")
//    }
//
//    override fun turnOff() {
//        super.turnOff()
//        brightnessLevel = 0
//        println("$name turned off.")
//    }
//
//    fun increaseBrightness() {
//        brightnessLevel++
//        println("Brightness increase to $brightnessLevel")
//    }
//}
//
//class SmartTvDevice(deviceName: String, deviceCategory: String) :
//    SmartDevice(name = deviceName, category = deviceCategory) {
//    override val deviceType = "Smart TV"
//    var speakerVolume = 2
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
//    var channelNumber = 1
//        set(value) {
//            if (value in 0..200) {
//                field = value
//            }
//        }
//
//    override fun turnOn() {
//        super.turnOn()
//        println("$name is turned on. Speaker volume is set to $speakerVolume and channel number is set to " +
//                "$channelNumber.")
//    }
//
//    override fun turnOff() {
//        super.turnOff()
//        println("$name is turned off.")
//    }
//
//    fun increaseSpeakerVolume() {
//        speakerVolume++
//        println("Speaker volume increased to $speakerVolume")
//    }
//
//    fun nextChannel() {
//        channelNumber++
//        println("Channel number increase to $channelNumber")
//    }
//}
//
//open class SmartDevice(val name: String = "Android TV", val category: String = "Entertainment") {
//    var deviceStatus = "online"
//    open val deviceType = "unknown"
//
//    constructor(name: String, category: String, statusCode: Int) : this(name = name, category = category) {
//        deviceStatus = when (statusCode) {
//            0 -> "offline"
//            1 -> "online"
//            else -> "unknown"
//        }
//    }
//
//    open fun turnOn() {
//        deviceStatus = "on"
//    }
//
//    open fun turnOff() {
//        deviceStatus = "off"
//    }
//}

///*
// * Ejemplo sobre el uso de clases, curso de ANDROID BASICS WITH COMPOSE
// * al detectar codigo comun en ambas implementaciones, es posible usar los
// * métodos de la clase padre para reutilizar dicho codigo, entonces cambiamos
// * el código de ambos métodos en la clase padre SmartDevice y llamamos a ese
// * código desde las clase hijo usando la palabra reservada super, se hace
// * invocando a los métodos desde el padre con super.turnOn() y super.turnOff()
// */
//
//fun main() {
//    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
//    smartDevice.turnOn()
//
//    smartDevice = SmartLightDevice("Google Light", "Utility")
//    smartDevice.turnOn()
//}
//
//class SmartHome(
//    val smartTvDevice: SmartTvDevice,
//    val smartLightDevice: SmartLightDevice
//) {
//    fun turnOnTv() {
//        smartTvDevice.turnOn()
//    }
//
//    fun turnOffTv() {
//        smartTvDevice.turnOff()
//    }
//
//    fun increaseTvVolume() {
//        smartTvDevice.increaseSpeakerVolume()
//    }
//
//    fun changeTvChannelToNext() {
//        smartTvDevice.nextChannel()
//    }
//
//    fun turnOnLight() {
//        smartLightDevice.turnOn()
//    }
//
//    fun turnOffLight() {
//        smartLightDevice.turnOff()
//    }
//
//    fun increaseLightBrightness() {
//        smartLightDevice.increaseBrightness()
//    }
//
//    fun turnOffAllDevices() {
//        smartLightDevice.turnOff()
//        smartTvDevice.turnOff()
//    }
//}
//
//class SmartLightDevice(deviceName: String, deviceCategory: String) :
//    SmartDevice(name = deviceName, category = deviceCategory) {
//    var brightnessLevel = 0
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
//
//    override fun turnOn() {
//        super.turnOn()
//        brightnessLevel = 2
//        println("$name turned on. The brightness level is $brightnessLevel")
//    }
//
//    override fun turnOff() {
//        super.turnOff()
//        brightnessLevel = 0
//        println("$name turned off.")
//    }
//
//    fun increaseBrightness() {
//        brightnessLevel++
//        println("Brightness increase to $brightnessLevel")
//    }
//}
//
//class SmartTvDevice(deviceName: String, deviceCategory: String) :
//    SmartDevice(name = deviceName, category = deviceCategory) {
//    var speakerVolume = 2
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
//    var channelNumber = 1
//        set(value) {
//            if (value in 0..200) {
//                field = value
//            }
//        }
//
//    override fun turnOn() {
//        super.turnOn()
//        println("$name is turned on. Speaker volume is set to $speakerVolume and channel number is set to " +
//                "$channelNumber.")
//    }
//
//    override fun turnOff() {
//        super.turnOff()
//        println("$name is turned off.")
//    }
//
//    fun increaseSpeakerVolume() {
//        speakerVolume++
//        println("Speaker volume increased to $speakerVolume")
//    }
//
//    fun nextChannel() {
//        channelNumber++
//        println("Channel number increase to $channelNumber")
//    }
//}
//
//open class SmartDevice(val name: String = "Android TV", val category: String = "Entertainment") {
//    var deviceStatus = "online"
//
//    constructor(name: String, category: String, statusCode: Int) : this(name = name, category = category) {
//        deviceStatus = when (statusCode) {
//            0 -> "offline"
//            1 -> "online"
//            else -> "unknown"
//        }
//    }
//
//    open fun turnOn() {
//        deviceStatus = "on"
//    }
//
//    open fun turnOff() {
//        deviceStatus = "off"
//    }
//}

///*
// * Ejemplo sobre el uso de clases, curso de ANDROID BASICS WITH COMPOSE
// * sobreescritura de métodos heredados, es posible que si bien todas las
// * clases tienen una forma de hacer turnOn y turnOff, cada una de ellas
// * tenga una forma particular de hacerlo, por eso es necesario llevar a
// * cabo una implementación particular de estos metodos, la cual puede
// * diferir de la implementación original en el padre
// * ahora para poder sobreescribir los métodos turnOn y turnOff de la clase
// * SmartDevice desde las clases SmartTvDevice y SmartLightDevice es necesario
// * hacer dos cosas antes, la primera es 'abrir' ambos metodos con el prefijo
// * open y la segunda es poner en las clases hijos los metodos con el prefijo
// * override
// * una vez hecha la sobreescritura de los métodos podemos hacer algunas pruebas
// * veamos la clase main
// * ahora se puede ver claramente como, un mismo metodo llamado desde la misma
// * variable, tiene dos conductas diferentes, ya que muestra dos salidas diferentes
// *   Android TV is turned on. Speaker volume is set to 2 and channel number is set to 1.
// *   Google Light turned on. The brightness level is 2
// * esto es un ejemplo de polimorfismo ya que ambos usan la misma interfaz de métodos
// * de la clase SmartDevice
// */
//
//fun main() {
//    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
//    smartDevice.turnOn()
//
//    smartDevice = SmartLightDevice("Google Light", "Utility")
//    smartDevice.turnOn()
//}
//
//class SmartHome(
//    val smartTvDevice: SmartTvDevice,
//    val smartLightDevice: SmartLightDevice
//) {
//    fun turnOnTv() {
//        smartTvDevice.turnOn()
//    }
//
//    fun turnOffTv() {
//        smartTvDevice.turnOff()
//    }
//
//    fun increaseTvVolume() {
//        smartTvDevice.increaseSpeakerVolume()
//    }
//
//    fun changeTvChannelToNext() {
//        smartTvDevice.nextChannel()
//    }
//
//    fun turnOnLight() {
//        smartLightDevice.turnOn()
//    }
//
//    fun turnOffLight() {
//        smartLightDevice.turnOff()
//    }
//
//    fun increaseLightBrightness() {
//        smartLightDevice.increaseBrightness()
//    }
//
//    fun turnOffAllDevices() {
//        smartLightDevice.turnOff()
//        smartTvDevice.turnOff()
//    }
//}
//
//class SmartLightDevice(deviceName: String, deviceCategory: String) :
//    SmartDevice(name = deviceName, category = deviceCategory) {
//    var brightnessLevel = 0
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
//
//    override fun turnOn() {
//        deviceStatus = "on"
//        brightnessLevel = 2
//        println("$name turned on. The brightness level is $brightnessLevel")
//    }
//
//    override fun turnOff() {
//        deviceStatus = "off"
//        brightnessLevel = 0
//        println("$name turned off.")
//    }
//
//    fun increaseBrightness() {
//        brightnessLevel++
//        println("Brightness increase to $brightnessLevel")
//    }
//}
//
//class SmartTvDevice(deviceName: String, deviceCategory: String) :
//    SmartDevice(name = deviceName, category = deviceCategory) {
//    var speakerVolume = 2
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
//    var channelNumber = 1
//        set(value) {
//            if (value in 0..200) {
//                field = value
//            }
//        }
//
//    override fun turnOn() {
//        deviceStatus = "on"
//        println("$name is turned on. Speaker volume is set to $speakerVolume and channel number is set to " +
//                "$channelNumber.")
//    }
//
//    override fun turnOff() {
//        deviceStatus = "off"
//        println("$name is turned off.")
//    }
//
//    fun increaseSpeakerVolume() {
//        speakerVolume++
//        println("Speaker volume increased to $speakerVolume")
//    }
//
//    fun nextChannel() {
//        channelNumber++
//        println("Channel number increase to $channelNumber")
//    }
//}
//
//open class SmartDevice(val name: String = "Android TV", val category: String = "Entertainment") {
//    var deviceStatus = "online"
//
//    constructor(name: String, category: String, statusCode: Int) : this(name = name, category = category) {
//        deviceStatus = when (statusCode) {
//            0 -> "offline"
//            1 -> "online"
//            else -> "unknown"
//        }
//    }
//
//    open fun turnOn() {
//        println("Smart device is turned on.")
//    }
//
//    open fun turnOff() {
//        println("Smart device is turned off.")
//    }
//}

///*
// * Ejemplo sobre el uso de clases, curso de ANDROID BASICS WITH COMPOSE
// * relaciones 'tiene-un', es cuando un atributo de una clase es instancia
// * de otra
// * ahora vamos a cambiar la posición de la función main para poder tenerla
// * más a la mano y creamos otra clase, esta vez es SmartHome, esta clase
// * tiene metodos para controlar dos dispositivos, uno es el smartTvDevice
// * y el otro es el smartLightDevice, desde la interfaz de SmartHome se pueden
// * controlar todos los dispositivos de la clase, es decir, todos los objetos
// * que la clase SmartHome tiene.
// */
//
//class SmartHome(
//    val smartTvDevice: SmartTvDevice,
//    val smartLightDevice: SmartLightDevice
//) {
//    fun turnOnTv() {
//        smartTvDevice.turnOn()
//    }
//
//    fun turnOffTv() {
//        smartTvDevice.turnOff()
//    }
//
//    fun increaseTvVolume() {
//        smartTvDevice.increaseSpeakerVolume()
//    }
//
//    fun changeTvChannelToNext() {
//        smartTvDevice.nextChannel()
//    }
//
//    fun turnOnLight() {
//        smartLightDevice.turnOn()
//    }
//
//    fun turnOffLight() {
//        smartLightDevice.turnOff()
//    }
//
//    fun increaseLightBrightness() {
//        smartLightDevice.increaseBrightness()
//    }
//
//    fun turnOffAllDevices() {
//        smartLightDevice.turnOff()
//        smartTvDevice.turnOff()
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
//
//class SmartLightDevice(deviceName: String, deviceCategory: String) :
//    SmartDevice(name = deviceName, category = deviceCategory) {
//    var brightnessLevel = 0
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
//
//    fun increaseBrightness() {
//        brightnessLevel++
//        println("Brightness increase to $brightnessLevel")
//    }
//}
//
//class SmartTvDevice(deviceName: String, deviceCategory: String) :
//    SmartDevice(name = deviceName, category = deviceCategory) {
//    var speakerVolume = 2
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
//    var channelNumber = 1
//        set(value) {
//            if (value in 0..200) {
//                field = value
//            }
//        }
//
//    fun increaseSpeakerVolume() {
//        speakerVolume++
//        println("Speaker volume increased to $speakerVolume")
//    }
//
//    fun nextChannel() {
//        channelNumber++
//        println("Channel number increase to $channelNumber")
//    }
//}
//
//open class SmartDevice(val name: String = "Android TV", val category: String = "Entertainment") {
//    var deviceStatus = "online"
//
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

///*
// * Ejemplo sobre el uso de clases, curso de ANDROID BASICS WITH COMPOSE
// * HERENCIA, es posible generar otras clases usando como base la clase
// * definida (SmartDevice) para tener un smart TV, o una smart light
// * toda clase creada es una clase inmutable, es decir, es una clase tipo
// * final, para poder extender una clase es necesario indicarlo con la
// * palabra reservada open
// * en el cuerpo de la nueva clase es posible definir propiedades de esta
// * clase (speakerVolume) que no esten presentes en la clase padre
// * (SmartDevice)
// * además es posible definir más propiedades y metodos para ser usados por
// * los objetos instanciados de esta clase
// * relaciones es-un, tanto SmartTVDevice como SmartLightDevice 'son' del
// * tipo SmartDevice, lo contrario no es posible afirmarlo, esta condición
// * debe ser satisfecha y no se debe usar herencia sólo para reutilizar
// * código
// */
//
//class SmartLightDevice(deviceName: String, deviceCategory: String) :
//    SmartDevice(name = deviceName, category = deviceCategory) {
//    var brightnessLevel = 0
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
//
//    fun increaseBrightness() {
//        brightnessLevel++
//        println("Brightness increase to $brightnessLevel")
//    }
//}
//
//class SmartTVDevice(deviceName: String, deviceCategory: String) :
//    SmartDevice(name = deviceName, category = deviceCategory) {
//    var speakerVolume = 2
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
//    var channelNumber = 1
//        set(value) {
//            if (value in 0..200) {
//                field = value
//            }
//        }
//
//    fun increaseSpeakerVolume() {
//        speakerVolume++
//        println("Speaker volume increased to $speakerVolume")
//    }
//
//    fun nextChannel() {
//        channelNumber++
//        println("Channel number increase to $channelNumber")
//    }
//}
//
//open class SmartDevice(val name: String = "Android TV", val category: String = "Entertainment") {
//    var deviceStatus = "online"
//
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
//    val category = "Entertainment"
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