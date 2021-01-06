package kt.面向对象.单例.懒汉式

//线程安全的懒汉式
class SingletonThreadDemo private constructor(){

    companion object {
        private var instance: SingletonThreadDemo? = null
            get() {
                if (field == null) {
                    field = SingletonThreadDemo()
                }
                return field
            }
    }

    @Synchronized
    fun get(): SingletonThreadDemo {
        return instance!!
    }
}