fun main(args: Array<String>) {
    println(birthdayGreeting(age = 5)) // se activa el valor por default de name al no enviar valor
    println(birthdayGreeting(name = "Rex", age = 3 ))
}

fun birthdayGreeting(name: String = "Rover", age: Int): String { // name tiene un valor por default
    val nameGreeting = "Happy Birthday, $name!"
    val ageGreeting = "You are now $age years old!"
    return "$nameGreeting\n$ageGreeting"
}

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
