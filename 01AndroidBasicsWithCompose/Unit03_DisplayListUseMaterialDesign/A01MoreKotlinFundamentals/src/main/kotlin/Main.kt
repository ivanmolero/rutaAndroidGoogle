fun main(args: Array<String>) {
    val question01 = Question<String>(
        questionText = "Quoth the raven ___",
        answer = "nevermore",
        difficulty = "medium"
    )
    val question02 = Question<Boolean>(
        questionText = "The sky is green. True or false",
        answer = false,
        difficulty = "medium"
    )
    val question03 = Question<Int>(
        questionText = "How many days are there between full moons?",
        answer = 28,
        difficulty = "hard"
    )
    println(question01)
    println(question03)
    println(question02)

}

class Question<T>(
    val questionText: String,
    val answer: T,
    val difficulty: String
)