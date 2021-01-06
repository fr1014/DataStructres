package kt.面向对象.单例.静态内部类

class SingletonDemo private constructor() {

    init {
        println("init")
    }

    companion object{
        val instance = SingletonHolder.holder
    }

    private object SingletonHolder{
        val holder = SingletonDemo()
    }
}

fun main() {
    SingletonDemo.instance
}