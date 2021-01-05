package kt.面向对象.封装_继承.抽象

abstract class Animal(val name:String) {

    abstract fun voice()

    fun print(){
        println("我的名字是${name}")
        voice()
    }
}