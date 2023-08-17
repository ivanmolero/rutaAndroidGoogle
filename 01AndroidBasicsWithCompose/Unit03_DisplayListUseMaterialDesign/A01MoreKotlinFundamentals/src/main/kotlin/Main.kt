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
    println()
//    esta invocación es sin la extensión ya que es una propiedad extendida
//    Quiz.printProgressBar()
//    ahora se invoca desde un objeto
    Quiz().printProgressBar()

//    val quiz = Quiz()
//    quiz.printQuiz()

//    tambien es posible invocar al metodo usando apply, es necesario aclarar que
//    el metodo invocado se hace desde una instancia y no es estatico, en este caso
//    el metodo printQuiz() se invoca desde el objeto instanciado quiz
    val quiz = Quiz().apply {
        printQuiz()
    }
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

/*
 * una clase singleton tiene varias formas de implementación, sin embargo en
 * kotlin es posible hacerlo muy simple, basta con el uso de la palabra object,
 * por lo demas la implementación es exactamente igual a la de una clase estándar
 * solo que es obligatorio el uso de valores por default
 * ojo que no tiene constructor
 * el acceso a los atributos se da invocando a la clase y luego a los atributos
 * usando <clase singleton>.<atributo>
 * */
object StudentProgress {
    var total: Int = 10
    var answered: Int = 3
}

/*
 * un objeto companion es un singleton que reside dentro de otra clase,
 * en este caso la clase Quiz, y se pueden invocar sus atributos sin hacer
 * referencia a dicho objeto, se hace directamente desde la clase Quiz
 *     println("${Quiz.answered} of ${Quiz.total} answered")
 *
 * */
class Quiz : ProgressPrintable {
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
    /*
     * al implementar la interfaz se necesita dejar de lado la propiedad
     * extendida, por eso se comenta el codigo más abajo
     * además, como ha sido declarado en la interfaz, es necesario usar
     * la palabra reservada override
     * */
    override val progressText: String
        get() = "$answered of $total answered"

    override fun printProgressBar() {
        repeat(Quiz.answered) { print("▓") }
        repeat(Quiz.total - Quiz.answered) { print("▒") }
        println()
        println(progressText)
    }

    companion object StudentProgress {
        var total: Int = 10
        var answered: Int = 3
    }

    /*
     * una scope function como let permite reducir el código de llamado de un
     * objeto, al hacer referencia al objeto desde donde se invoca let usando
     * el termino it
     * */
    fun printQuiz() {
        question01.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        question02.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
        question03.let {
            println(it.questionText)
            println(it.answer)
            println(it.difficulty)
        }
    }
}

/*
 * una propiedad extendida (extended property) puede ser agregada a una clase
 * desde fuera de la clase, el siguiente codigo hace eso con la clase Quiz,
 * ojo, las propiedades extendidas no pueden almacenar datos, deben solo para
 * obtener datos (get-only)
 * */
//val Quiz.StudentProgress.progressText: String
//    get() = "$answered of $total answered"

/*
 * una funcion extendida se hace de manera similar a una función, solo se debe
 * tener cuidado de usar la clase a extender con la función
 * */
//fun Quiz.StudentProgress.printProgressBar() {
//    repeat(Quiz.answered) { print("▓") }
//    repeat(Quiz.total - Quiz.answered) { print("▒") }
//    println()
//    println(Quiz.progressText)
//}

/*
 * las interfaces se usan para poder ser extendidas y mantener la consistencia entre
 * las clases que las implementen, la implementación de una interfaz es un compromiso
 * para tener todos los atributos y metodos implementados en la clase, para el ejemplo hay
 * un atributo y un metodo
 * en este caso se va a implementar por la clase Quiz
 * */
interface ProgressPrintable {
    val progressText: String
    fun printProgressBar()
}