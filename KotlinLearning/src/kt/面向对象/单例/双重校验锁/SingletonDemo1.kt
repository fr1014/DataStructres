package kt.面向对象.单例.双重校验锁

//无属性的双重校验锁
class SingletonDemo1 private constructor() {
    companion object {
        val instance: SingletonDemo1 by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            SingletonDemo1()
        }
    }
}