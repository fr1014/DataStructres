package kt.面向对象

class Person {
    var name: String = ""
    var age: Int = 0
    fun say(content: String) {
        println(content)
    }
}

fun main(args: Array<String>) {
    val person = Person()
    person.name = "范瑞"
    person.age = 22
    print("${person.name}年龄是${person.age}，他说")
    person.say("Hello World!!!")
}