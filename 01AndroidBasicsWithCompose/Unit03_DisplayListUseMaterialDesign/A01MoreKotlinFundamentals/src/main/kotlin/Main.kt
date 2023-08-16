fun main(args: Array<String>) {
    val question01 = Question<String>(
        questionText = "Quoth the raven ___",
        answer = "nevermore",
        difficulty = Difficulty.EASY
    )
    val question02 = Question<Boolean>(
        questionText = "The sky is green. True or false",
        answer = false,
        difficulty = Difficulty.MEDIUM
    )
    val question03 = Question<Int>(
        questionText = "How many days are there between full moons?",
        answer = 28,
        difficulty = Difficulty.HARD
    )
    println(question01)
    println(question02)
    println(question03)

}

/*
 * el prefijo data hace que una clase tenga implementados varios metodos
 * entre ellos esta equals, hashCode, toString, componentN, copy
 * esto va en automatico y como se puede ver, la impresión cambia en este
 * punto
 *     Question(questionText=Quoth the raven ___, answer=nevermore, difficulty=EASY)
 *     Question(questionText=The sky is green. True or false, answer=false, difficulty=MEDIUM)
 *     Question(questionText=How many days are there between full moons?, answer=28, difficulty=HARD)
 * antes de esto la salida era
 *     Question@19469ea2
 *     Question@13221655
 *     Question@2f2c9b19
 * */
data class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty
)

/*
 * para los casos en los que los valores a usar tienen un rango definido
 * se recomienda el uso de enumeraciones (enum class), al ser valores
 * constantes y no variar, estos valores se definen en mayúsculas (uppercase)
 * */
enum class Difficulty {
    EASY, MEDIUM, HARD
}