import java.util.ArrayList

enum class Daypart {
    MORNING, AFTERNOON, EVENING
}

data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
)

fun main(args: Array<String>) {
    val event = Event(
        title = "Study Kotlin",
        description = "Commit to studying Kotlin at least 15 minutes per day.",
        daypart = Daypart.EVENING,
        durationInMinutes = 15
    )
    println(event)

    val events = mutableListOf<Event>();
    events.add(Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0))
    events.add(Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15))
    events.add(Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30))
    events.add(Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60))
    events.add(Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10))
    events.add(Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45))

    // count short events
    val totalShortEvents = events.fold(0) {
        count, event -> if (event.durationInMinutes < 60) count + 1 else count
    }
    println("You have $totalShortEvents short events")

    // count by daypart
    val groupByDaypart = events.groupBy {
        it.daypart
    }
    groupByDaypart.forEach {
        println("${it.key}: ${it.value.size} events")
    }
//    for (element in groupByDaypart) {
//        println("${element.key}: ${element.value.size} events")
//    }
    println("Last event of the day: ${events.last().title}")

//    val durationOfEvent = if (events[0].durationInMinutes < 60) {
//        "short"
//    } else {
//        "long"
//    }
    println("Duration of first event of the day: ${events[0].durationOfEvent}")

}

val Event.durationOfEvent: String
    get() = if (durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }