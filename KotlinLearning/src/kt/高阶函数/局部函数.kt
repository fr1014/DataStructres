package kt.高阶函数

fun getMathFunc(type: String): (Int) -> Int {

    //平方
    fun square(n: Int): Int {
        return n * n
    }

    //立方
    fun cube(n: Int): Int {
        return n * n * n
    }

    //阶乘
    fun factorial(n: Int): Int {
        var result = 1
        for (index in 2..n) {
            result *= index
        }
        return result
    }

    when (type) {
        "square" -> return ::square
        "cube" -> return ::cube
        else -> return ::factorial
    }
}

fun main(args: Array<String>) {
    var mathFunc = getMathFunc("square")
    println(mathFunc(9))
    mathFunc = getMathFunc("cube")
    println(mathFunc(9))
    mathFunc = getMathFunc("factorial")
    println(mathFunc(9))
}
