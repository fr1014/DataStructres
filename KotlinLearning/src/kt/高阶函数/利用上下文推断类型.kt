package kt.高阶函数

fun main(args: Array<String>) {

    //由于程序定义了square变量的类型，因为Kotlin可以推断出lambda表达式的形参类型
    //所以Lambda表达式可以省略形参类型
    var square: (Int) -> Int = { n -> n * n }
    println(square(4))

    var result = { base: Int, exponent: Int ->
        var result = 1;
        for (i in 1..exponent) {
            result *= base
        }
        result

    }(2, 3)
    println(result)

    //使用Lambda表达式定义去除条件：长度大于3的集合元素被去除
    //由于dropWhile()方法的形参是(T) -> Boolean类型
    //因此调用该方法时可省略形参类型
    val list = listOf("Kotlin", "Java", "C", "C++", "Go");
    val rt = list.dropWhile { e -> e.length > 3 }
    println(rt)

}