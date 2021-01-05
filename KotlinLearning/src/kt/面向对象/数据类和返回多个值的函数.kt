package kt.面向对象

import java.util.HashMap

data class Result(val result: Int, val status: String)

fun factorial(n: Int): Result {
    if (n == 1) {
        return Result(1, "成功")
    }
    return if (n > 1) {
        Result(factorial(n - 1).result, "成功")
    } else {
        Result(-1, "参数必须大于0")
    }
}

fun main(args: Array<String>) {
    var (rt, status) = factorial(6)
    println(rt)
    println(status)
}