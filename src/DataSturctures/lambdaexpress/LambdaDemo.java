package DataSturctures.lambdaexpress;

//interface SayHello {
//    void sayHello();
//}

import java.util.ArrayList;
import java.util.List;

interface Fun {
    int add(int x, int y);

}

public class LambdaDemo {

    public static void main(String[] args) {
//        SayHello sh = new SayHello() {
//            @Override
//            public void sayHello() {
//                System.out.println("hello word");
//            }
//        };
//
//        sh.sayHello();

        //复制方法名后的括号，->,{}
//        SayHello sh = () -> {
//            System.out.println("hello word by lambda");
//        };
//        sh.sayHello();

//        Fun fun = new Fun() {
//            @Override
//            public int add(int x, int y) {
//                return x + y;
//            }
//        };

        Fun fun = (int x, int y) -> {
            return x + y;
        };

        System.out.println(fun.add(3, 5));

        List<Integer> l = new ArrayList<>();
    }
}
