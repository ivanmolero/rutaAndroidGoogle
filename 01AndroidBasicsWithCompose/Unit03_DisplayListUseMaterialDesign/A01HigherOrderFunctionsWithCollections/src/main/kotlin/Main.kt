import entities.Cookie

val cookies = listOf(
    Cookie(
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main(args: Array<String>) {
    /*
     * la función forEach recibe como parametro un elemento de tipo (T) -> Unit, es
     * decir, un lambda, el parametro entrante se conoce como it si no es renombrado
     * **/
    cookies.forEach {
        println("Menu item: ${it.name}")
    }
    /*
     * la función map sirve para crear otra collection basandose en una existente,
     * en este caso se crea un List<String>,
     * **/
    val fullMenu = cookies.map {
        "${it.name} - $${it.price}"
    }
    println()
    println("FULL MENU")
    fullMenu.forEach { println(it) }
    /*
     * la función filter sirve para crear una lista del mismo tipo de la original, solo
     * que el valor booleano debe ser true para que el elemento esté presente
     * **/
    val softBaked = cookies.filter {
        it.softBaked // valor booleano
    }
    println()
    println("SOFT COOKIES")
    softBaked.forEach { println("${it.name} - $${it.price}") }
    println()
    /*
     * la función groupBy permite generar un mapa, donde las keys son los valores unicos
     * que pueden tomar los elementos de la lista y los values son listas con los elementos
     * originales agrupados
     * esto genera una partición de la lista en base al valor de uno de los atributos de los
     * objetos que la componen
     * **/
    val groupedMenu = cookies.groupBy {
        it.softBaked // valor booleano para hacer la agrupación
    }
    val softBakedGroup = groupedMenu[true] ?: listOf()
    val crunchyGroup = groupedMenu[false] ?: listOf()
    println("SOFT COOKIES GROUP")
    softBakedGroup.forEach { println("${it.name} - $${it.price}") }
    println()
    println("CRUNCHY COOKIES GROUP")
    crunchyGroup.forEach { println("${it.name} - $${it.price}") }
    println()
    /*
     * la función fold permite generar un solo valor desde una lista
     * fold recibe dos parametros, se necesita el primero (total) como acumulador, y el segundo
     * representa un valor en la lista (cookie), el valor inicial es enviado como parametro de
     * fold y se asigna a la primera variable, la salida de la función lambda se reasigna a la
     * variable acumuladora
     * **/
    val totalPrice = cookies.fold(0.0) {
        total, cookie -> total + cookie.price
    }
    println("Total price: $$totalPrice")
    println()
    /*
     * la función sortedBy permite ordenar una lista por un valor, en este caso, de atributo de
     * los objetos, solo hay que indicarlo en la lambda
     * **/
    val alphabeticalOrder = cookies.sortedBy {
        it.name
    }
    println("MENU EN ORDEN ALFABETICO")
    alphabeticalOrder.forEach {
        println(it.name)
    }
    println()
    /*
     * RESUMEN
     * - map()      genera una lista en base a la lista inicial
     * - filter()   genera una sublista del mismo tipo por condición
     * - groupBy()  genera sublistas en base a un criterio de agrupación
     * - fold()     genera un valor unico en base a una lista
     * - sortedBy() genera una lista ordenada en base a la lista original
     * **/
}