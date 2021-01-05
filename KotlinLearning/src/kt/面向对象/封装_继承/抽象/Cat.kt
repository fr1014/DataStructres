package kt.面向对象.封装_继承.抽象

class Cat(name:String) : Animal(name) {

    //初始化块，可以做一些初始化操作
    init {
        print()
    }

    override fun voice() {
        println("喵喵喵")
    }
}

fun main() {
    Cat("小猫")
}