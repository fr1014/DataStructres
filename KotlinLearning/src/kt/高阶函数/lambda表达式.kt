package kt.高阶函数

fun main(args: Array<String>) {
    //定义一个lambda表达式，并将它赋值给变量square
    var square = { n: Int ->
        n * n
    }
    println(square(5))

    //定义一个lambda表达式，并在其后面添加圆括号来调用该lambda表达式
    var result = { base: Int, exponent: Int ->
        var result = 1
        for (i in 1..exponent) {
            result *= base
        }
        result
    }(3,4)
    println(result)
}