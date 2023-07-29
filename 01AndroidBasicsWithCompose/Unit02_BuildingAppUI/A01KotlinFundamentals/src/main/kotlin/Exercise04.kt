/*
 * cuarto ejercicio, Song catalog
 * */

fun main() {
    val song = Song("hola", "juanes", 1989, 2500)
    song.description()
    println("popular? ${song.isPopular}")
}

class Song (
    val title: String,
    val artist: String,
    val yearPublished: Int,
    val playCount: Int
) {
    var isPopular: Boolean = false
        get() = playCount >= 1000

    fun description() {
        println("$title, performed by $artist, was released in $yearPublished")
    }
}
