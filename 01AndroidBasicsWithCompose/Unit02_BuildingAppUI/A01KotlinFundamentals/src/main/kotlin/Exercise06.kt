/*
 * sexto ejercicio, Foldable phones
 * */

fun main() {
    val phone = Phone()
    phone.checkPhoneScreenLight()
    phone.switchOn()
    phone.checkPhoneScreenLight()
    phone.switchOff()
    phone.checkPhoneScreenLight()

    println("Foldable phone")
    val foldablePhone = FoldablePhone(isScreenLightOn = false)
    foldablePhone.checkPhoneScreenLight()
    foldablePhone.switchOn()
    foldablePhone.checkPhoneScreenLight()
    foldablePhone.unfold()
    foldablePhone.checkPhoneScreenLight()
    foldablePhone.switchOn()
    foldablePhone.checkPhoneScreenLight()
}

class FoldablePhone(isScreenLightOn: Boolean, var isFolded: Boolean = true) : Phone(isScreenLightOn) {
    fun unfold() {
        isFolded = false
    }

    fun fold() {
        isFolded = true
    }

    override fun switchOn() {
        isScreenLightOn = if (!isFolded) true else false
    }
}

open class Phone(var isScreenLightOn: Boolean = false) {
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}
