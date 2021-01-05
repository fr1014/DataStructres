package kt.面向对象.封装_继承.继承

class Son: Father() {
    override fun action(){
        println("乖巧")
    }
}

fun main() {
    val son = Son()
    son.speak()
    son.action()
}