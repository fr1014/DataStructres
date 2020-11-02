package kt

fun main(args: Array<String>) {
//    println(factRec(4))
    val list = listOf("java", "kotlin", null, "go")
    for (i in list.indices){
        println(list[i])
    }
}

tailrec fun factRec(n: Int, total: Int = 1): Int =
    if (n == 1) total else factRec(n - 1, total * n)