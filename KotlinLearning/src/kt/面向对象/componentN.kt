package kt.面向对象

import java.util.HashMap

class User(name: String, pass: String, age: Int) {
    var name = name
    var pass = pass
    var age = age

    //定义operator修饰的component方法，用于解构
    operator fun component1(): String {
        return this.name
    }

    operator fun component2(): String {
        return this.pass
    }

    operator fun component3(): Int {
        return this.age
    }
}

fun main(args: Array<String>) {
    val user = User("fr", "fanrui07", 22)

    //将user对象解构给2个变量
    //只利用User对象的component1()和component2()方法
    var (name, pass) = user
    println(name)
    println(pass)

    var (name2, pass2, age) = user
    println(name2)
    println(pass2)
    println(age)

    //可通过下划线(_)来占位，忽略componentN()方法的返回值
    var (_, pass3, age3) = user
    println(pass3)
    println(age3)

    //在Lambda表达式中的解构
    val map: HashMap<Int, Int> = mutableMapOf(12 to 20, 20 to 1) as HashMap<Int, Int>
    map.mapValues { (_, value) -> println("$value!") }
}