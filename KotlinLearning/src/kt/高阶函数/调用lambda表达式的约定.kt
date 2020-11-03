package kt.高阶函数

fun main(args: Array<String>) {
    var list = listOf("Kotlin", "Java", "C", "Go")
    var rt = list.dropWhile { it.length > 3 }
    println(rt)

    //
    var map = mutableMapOf("疯狂Android讲义" to 56)

    list.associateTo(map) { "疯狂${it}讲义" to it.length }
    println(map)

    var rtx = list.reduce() { sum, element -> sum + element }
    println(rtx)
}