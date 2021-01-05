package kt.面向对象.封装_继承.接口

class Dog : IAnimal {

    init {
        name()
        color()
    }

    override fun name() {
        println("我叫小柯基")
    }

    override fun color() {
        println("我是棕色的")
    }
}

fun main() {
    Dog()
}