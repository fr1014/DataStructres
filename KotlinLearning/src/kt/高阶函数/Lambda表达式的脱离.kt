package kt.高阶函数

var lambdaList = java.util.ArrayList<(Int) -> Int>()

fun collectFunc(fn: (Int) -> Int) {
    lambdaList.add(fn)
}

fun main(args: Array<String>) {
    collectFunc { it * it }
    collectFunc { it * it * it }
    println("lambdaList.size = ${lambdaList.size}")
    for (i in lambdaList.indices) {
        println(lambdaList[i](2))
    }
}