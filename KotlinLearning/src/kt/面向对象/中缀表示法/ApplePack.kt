package kt.面向对象.中缀表示法

class ApplePack(weight: Double) {
    var weight = weight
    override fun toString(): String {
        return "ApplePack(weight=${this.weight})"
    }
}

class Apple(weight: Double) {
    var weight = weight
    override fun toString(): String {
        return "Apple(weight=$weight)"
    }

    infix fun add(other: Apple): ApplePack {
        return ApplePack(this.weight + other.weight)
    }

    infix fun drop(other:Apple):Apple{
        this.weight -= other.weight
        return this
    }
}

fun main(args: Array<String>) {
    var origin = Apple(3.4)

    val ap = origin add Apple(2.4)
    println(ap)

    origin drop Apple(2.4)
    println(origin)
}