package kt.高阶函数

fun main(args: Array<String>) {
    //定义匿名函数，赋支给sum变量
//    var sum = fun(a: Int, b: Int): Int {
//        return a + b
//    }
//    println(sum(1, 2))

    //如果系统可以推断出匿名函数的形参类型，那么就可以省略形参类型
    var filteredList = listOf(3, 5, 7, 10, 12, 15, 25).filter(
        fun(element): Boolean {
            return element > 10
        })
    println(filteredList)

    var sum = fun(a: Int, b: Int) = a + b
    println(sum(1, 2))
    var rt = listOf(3, 5, 7, 10, 12, 15, 25).filter(
        fun(element) = element > 10
    )
    println(rt)
}