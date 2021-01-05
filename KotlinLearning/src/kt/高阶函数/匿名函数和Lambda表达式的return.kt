package kt.高阶函数

fun main(args: Array<String>) {
    val list = listOf(1, 3, 4, 5, 2, 6)
    list.forEach(fun(n) {
        println("元素依次是${n}")
        return
    })

    list.forEach { n ->
        println("元素依次是${n}")
        return
    }
}