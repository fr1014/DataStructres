package kt.高阶函数

fun main(args: Array<String>) {
    var square: (Int) -> Int = { it * it }
    println(square(2))
    val list = listOf("Kotlin", "Java", "C")
    val rt = list.dropWhile { it.length > 3 }
    println(rt)
}