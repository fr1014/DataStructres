package kt.高阶函数

fun getMathFun(type: String): (Int) -> Int {
    when (type) {
        "square" -> return { n: Int ->
            n * n
        }
        "cube" -> return { n: Int ->
            n * n * n
        }
        else -> return { n: Int ->
            var result: Int = 1;
            for (index in 2..n) {
                result *= index
            }
            result
        }
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
