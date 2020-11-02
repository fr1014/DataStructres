package kt

fun main(args: Array<String>) {
    var myfun: (Int, Int) -> Int
    myfun = ::pow
    println(myfun(2, 4))
    myfun = ::area
    println(myfun(2, 4))
}

fun pow(base: Int, exponent: Int): Int {
    var result = 1;
    for (i in 1..exponent) {
        result *= base
    }
    return result;
}

fun area(width: Int, height: Int): Int {
    return width * height
}
