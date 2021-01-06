package kt.面向对象.单例.双重校验锁

//含一个属性的双重校验锁
class SingletonDemo2 private constructor(private val property: Int) { //这里可以根据实际需求发生改变

    companion object {
        @Volatile
        private var instance: SingletonDemo2? = null
        fun getInstance(property: Int) =
            instance ?: synchronized(this) {
                instance ?: SingletonDemo2(property).also { instance = it }
            }
    }
}