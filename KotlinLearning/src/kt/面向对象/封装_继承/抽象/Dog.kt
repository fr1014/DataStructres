package kt.面向对象.封装_继承.抽象

class Dog(name:String) : Animal(name) {
    override fun voice() {
        println("汪汪汪")
    }
}

fun main() {
    Dog("小柯基").print()
}