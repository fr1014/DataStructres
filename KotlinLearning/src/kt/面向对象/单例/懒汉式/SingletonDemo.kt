package kt.面向对象.单例.懒汉式

//懒汉式
class SingletonDemo private constructor(){

    companion object{
        private var instance : SingletonDemo? = null
        get() {
            if (field == null){
                field = SingletonDemo()
            }
            return field
        }
    }

    fun get():SingletonDemo{
        return instance!!
    }
}