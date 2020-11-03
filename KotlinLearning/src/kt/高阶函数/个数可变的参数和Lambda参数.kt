package kt.高阶函数

fun <T> test(vararg names: String, transform: (String) -> T): List<T> {
    var mutableList: MutableList<T> = mutableListOf()
    for (name in names) {
        mutableList.add(transform(name))
    }
    return mutableList.toList();
}

fun main(args: Array<String>) {
    var list1 = test("Kotlin", "Java", "Go") { it.length }
    println(list1)
    var list2 = test("Kotlin", "Java", "Go") { "疯狂${it}讲义" }
    println(list2)
}