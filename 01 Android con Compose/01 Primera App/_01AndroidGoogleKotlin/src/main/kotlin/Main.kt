/*
 * Ejercicio 10
 */
fun main(args: Array<String>) {
    val firstCity = "Ankara"
    val firstLowTemp = 27
    val firstHighTemp = 31
    val firstChanceRain = 82
    println(detailWetherCity(city = firstCity, lowTemp = firstLowTemp, highTemp = firstHighTemp, chanceRain = firstChanceRain))
    println()

    val secondCity = "Tokyo"
    val secondLowTemp = 32
    val secondHighTemp = 36
    val secondChanceRain = 10
    println(detailWetherCity(city = secondCity, lowTemp = secondLowTemp, highTemp = secondHighTemp, chanceRain = secondChanceRain))
    println()

    val thirdCity = "Cape Town"
    val thirdLowTemp = 59
    val thirdHighTemp = 64
    val thirdChanceRain = 2
    println(detailWetherCity(city = thirdCity, lowTemp = thirdLowTemp, highTemp = thirdHighTemp, chanceRain = thirdChanceRain))
    println()

    val fourthCity = "Guatemala City"
    val fourthLowTemp = 50
    val fourthHighTemp = 55
    val fourthChanceRain = 7
    println(detailWetherCity(city = fourthCity, lowTemp = fourthLowTemp, highTemp = fourthHighTemp, chanceRain = fourthChanceRain))
    println()
}

fun detailWetherCity(city: String, lowTemp: Int, highTemp: Int, chanceRain: Int): String {
    val message = """
        City: $city
        Low temperature: $lowTemp, High temperature: $highTemp
        Chance of rain: $chanceRain%
    """.trimIndent()
    return message
}

/*
 * Ejercicio 09
 */
//fun main(args: Array<String>) {
//    val firstTimeSpendToday = 300
//    val firstTimeSpendYesterday = 250
//    println("$firstTimeSpendToday - $firstTimeSpendYesterday: ${comparePhoneUse(timeSpendToday = firstTimeSpendToday, timeSpendYesterday = firstTimeSpendYesterday)}")
//
//    val secondTimeSpendToday = 300
//    val secondTimeSpendYesterday = 300
//    println("$secondTimeSpendToday - $secondTimeSpendYesterday: ${comparePhoneUse(timeSpendToday = secondTimeSpendToday, timeSpendYesterday = secondTimeSpendYesterday)}")
//
//    val thirdTimeSpendToday = 200
//    val thirdTimeSpendYesterday = 220
//    println("$thirdTimeSpendToday - $thirdTimeSpendYesterday: ${comparePhoneUse(timeSpendToday = thirdTimeSpendToday, timeSpendYesterday = thirdTimeSpendYesterday)}")
//
//}
//
//fun comparePhoneUse(timeSpendToday: Int, timeSpendYesterday: Int): Boolean {
//    return timeSpendToday > timeSpendYesterday
//}

/*
 * Ejercicio 08
 */
//fun main() {
//    val steps = 4000
//    val caloriesBurned = PedometerStepsToCalories(steps);
//    println("Walking $steps steps burns $caloriesBurned calories")
//}
//
//fun PedometerStepsToCalories(numberOfSteps: Int): Double {
//    val caloriesBurnedForEachStep = 0.04
//    val totalCaloriesBurned = numberOfSteps * caloriesBurnedForEachStep
//    return totalCaloriesBurned
//}
// se corrige el uso de mayusculas y minusculas según las recomendaciones
// de estilo para Kotlin

/*
 * Ejercicio 07
 */
//fun main(args: Array<String>) {
//    val operatingSystem = "Chrome OS"
//    val emailId = "sample@gmail.com"
//    println(displayAlertMessage(operatingSystem = operatingSystem, emailId = emailId))
//
//    val firsUserEmailId = "user_one@gmail.com"
//    println(displayAlertMessage(emailId = firsUserEmailId))
//
//    val secondUserOperatingSystem = "Windows"
//    val secondUserEmailId = "user_two@gmail.com"
//    println(displayAlertMessage(operatingSystem = secondUserOperatingSystem, emailId = secondUserEmailId))
//
//    val thirdUserOperatingSystem = "Mac OS"
//    val thirdUserEmailId = "user_three@gmail.com"
//    println(displayAlertMessage(operatingSystem = thirdUserOperatingSystem, emailId = thirdUserEmailId))
//
//}
//
//fun displayAlertMessage(operatingSystem: String = "Unknown OS", emailId: String): String {
//    return "There's a new sing-in request on $operatingSystem for your Google Account $emailId"
//}

//fun main(args: Array<String>) {
//    val operatingSystem = "Chrome OS"
//    val emailId = "sample@gmail.com"
//    println(displayAlertMessage(operatingSystem = operatingSystem, emailId = emailId))
//}
//
//fun displayAlertMessage(operatingSystem: String, emailId: String): String {
//    return "There's a new sing-in request on $operatingSystem for your Google Account $emailId"
//}

/*
 * Ejercicio 06
 */
//fun main(args: Array<String>) {
//    val firstNumber = 10
//    val secondNumber = 5
//    val thirdNumber = 8
//
//    val result = add(firstNumber, secondNumber)
//    val anotherResult = add(firstNumber, thirdNumber)
//    val resultSubstract = substract(firstNumber, secondNumber)
//    val anotherSubstract = substract(firstNumber, thirdNumber)
//
//    println("$firstNumber + $secondNumber = $result")
//    println("$firstNumber + $thirdNumber = $anotherResult")
//    println("$firstNumber - $secondNumber = $resultSubstract")
//    println("$firstNumber - $thirdNumber = $anotherSubstract")
//}
//
//fun add(number1: Int, number2: Int): Int {
//    return number1 + number2
//}
//
//fun substract(number1: Int, number2: Int): Int {
//    return number1 - number2
//}
//fun main(args: Array<String>) {
//    val firstNumber = 10
//    val secondNumber = 5
//
//    println("$firstNumber + $secondNumber = ${firstNumber + secondNumber}")
//}

/*
 * Ejercicio 05
 */
//fun main(args: Array<String>) {
//    val baseSalary = 5000
//    val bonusAmount = 1000
//    val totalSalary = baseSalary + bonusAmount
//    println("Congratulations for your bonus! You will receive a total of $totalSalary (additional bonus).")
//}
// muestra en la salida 5000 + 1000
// es necesario quitar las comillas en la asignación de valor de
// la variable totalSalary

/*
 * Ejercicio 04
 */
//fun main(args: Array<String>) {
//    val numberOfAdults = "20".toInt()
//    val numberOfKids = "30".toInt()
//    val total = numberOfAdults + numberOfKids
//    println("The total party size is: $total")
//}
// el programa imprime 2030
// para que imprima el valor adecuado se puede usar
// en los strings .toInt(), esto devuelve un valor
// entero que si se suma en la variable total

/*
 * Ejercicio 03
 */
//fun main(args: Array<String>) {
//    val discountPercentage: Int
//    val offer: String
//    val item = "Google Chromecast"
//    discountPercentage = 20
//    offer = "Sale - Up to $discountPercentage% discount on $item! Hurry up!"
//
//    println(offer)
//}
// son dos errores, por el uso de val no se debe asignar un valor inicial,
// basta con declarar las variables y luego hacer la asignación correspondient
// eliminando la asignación inicial ya no hay errores

/*
 * Ejercicio 02
 */
//fun main(args: Array<String>) {
//    println("New chat message from a friend")
//}
// error encontrado el cierre del string con ' y no con "
// ademas el cierre del atributo de println con } y no con )

/*
 * Ejercicio 01
 */
//fun main(args: Array<String>) {
//    println("Use the val keyword when the value doesn't change.")
//    println("Use the var keyword when the value can change.")
//    println("When yo define a function, yo define the parameters that can be passed to it.")
//    println("When yo call a function, yo pass arguments for the parameters.")
//}

//fun main(args: Array<String>) {
//    println(birthdayGreeting(age = 5)) // se activa el valor por default de name al no enviar valor
//    println(birthdayGreeting(name = "Rex", age = 3 ))
//}
//
//fun birthdayGreeting(name: String = "Rover", age: Int): String { // name tiene un valor por default
//    val nameGreeting = "Happy Birthday, $name!"
//    val ageGreeting = "You are now $age years old!"
//    return "$nameGreeting\n$ageGreeting"
//}

//fun main(args: Array<String>) {
//    println(birthdayGreeting("Rover", 5))
//    println(birthdayGreeting(name = "Rex", age = 3 )) // argumentos con nombre en la llamada a la funcion
//}
//
//fun birthdayGreeting(name: String, age: Int): String {
//    val nameGreeting = "Happy Birthday, $name!"
//    val ageGreeting = "You are now $age years old!"
//    return "$nameGreeting\n$ageGreeting"
//}

///*
// * este es un comentario muy largo
// * que toma mas de una linea en el
// * texto
// */
//fun main(args: Array<String>) {
//    println(birthdayGreeting("Rover", 5))
//    println(birthdayGreeting("Rex", 3 ))
////    println(birthdayGreeting("Rover"))
////    println(birthdayGreeting("Rex"))
//}
//
//fun birthdayGreeting(name: String, age: Int): String {
//    val nameGreeting = "Happy Birthday, $name!"
//    val ageGreeting = "You are now $age years old!"
//    return "$nameGreeting\n$ageGreeting"
//}

//fun birthdayGreeting(): String {
//    val nameGreeting = "Happy Birthday, Rover!"
//    val ageGreeting = "You are now 5 years old!"
//    return "$nameGreeting\n$ageGreeting"
//}

//    // Create a variable for the number of unread messages.
//    var count = 10
//    println("You have $count unread messages.")
//
//    // Decrease the number of messages by 1.
//    count--
//    println("You have $count unread messages.")

//    val notificationEnabled = false
//    println("Are notifications enabled? $notificationEnabled")

//    println("Say \"hello\"")

//    val nextMeeting = "Next meeting is: "
//    val date = "January 1"
//    val reminder = nextMeeting + date + " at work"
//    println(reminder)

//    val trip1: Double = 3.2
//    val trip2: Double = 4.1
//    val trip3: Double = 1.72
//    val totalTripLength: Double = trip1 + trip2 + trip3
//    println("$totalTripLength miles left to destination")

//    var count = 10
//    println("You have $count unread messages.")
//    count++
//    println("You have $count unread messages.")
//    count--
//    count--
//    println("You have $count unread messages.")

//    var cartTotal = 0
//    println("Total: $cartTotal")
//    cartTotal = 20
//    println("Total: $cartTotal")

//    val photosDeleted = 10
//    val photosLeft = 90
//    println("${photosLeft + photosDeleted} photos")
//    println("$photosDeleted photos deleted")
//    println("$photosLeft photos left")

//    val unreadCount = 5
//    val readCount = 100
//    println("You have ${unreadCount + readCount} total messages in your inbox.")

//    println("Hello Android!")
//    println("Hello Ivan!")
//    println(5 + 8)
//    println("45" + "72")
