fun main() {
    val result =
        modifyString("hello world") { it.toUpperCase() } // лямбда находится вне скобок, так как она является последним параметром
    println(result)

    printModifyCollectionSum(listOf(1, 2, 3, 4, 5, 6)) { println(it.sum()) }
}

// создание функции высшего порядка
fun modifyString(string: String, modify: (String) -> String): String {
    return modify(string)
}

// создание встраивоемой функции высшего порядка
inline fun printModifyCollectionSum(list: List<Int>, operator: (List<Int>) -> Unit) { // ключевое слово inline позволяет избежать создания объекта анонимного класса при вызове функции высшего порядка
    operator(list)
} // теперь ее вызов для компилятора аналогичен list.sum(), если operator = { it.sum() }
