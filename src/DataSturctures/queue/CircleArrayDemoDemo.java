package DataSturctures.queue;

import java.util.Scanner;

/**
 * 数组模拟环形队列
 * 会牺牲一个存储单元
 */
public class CircleArrayDemoDemo {

    public static void main(String[] args) {
        CircleArrayDemo queue = new CircleArrayDemo(3);

        Scanner sc = new Scanner(System.in);
        char key = ' ';
        boolean loop = true;
        while (loop) {
            System.out.println("a:入队列一个数");
            System.out.println("g:出队列一个数");
            System.out.println("s:显示队列中的数");
            System.out.println("e:退出程序");
            key = sc.next().charAt(0);
            switch (key) {
                case 'a':
                    System.out.print("请输入一个数：");
                    int value = sc.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g':
                    try {
                        System.out.println(queue.getQueue());
                    } catch (RuntimeException e) {
                        System.out.println("队列为空，无法取出数据！");
                    }
                    break;
                case 's':
                    queue.show();
                    break;
                case 'e':
                    loop = false;
                    break;
            }
        }
        System.out.println("程序已退出");
        System.exit(0);
    }

}

class CircleArrayDemo {
    private int front; //指向队列的第一个元素
    private int rear;  //指向队列的最后一个元素
    private int maxSize;   //队列的最大容量
    private int[] arr;     //用于存放数据，模拟队列

    public CircleArrayDemo(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //判断队列是否已满
    public boolean isFull() {
        System.out.println("rear:" + rear);
        System.out.println("front:" + front);
        System.out.println("m:" + maxSize);
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int data) {
        //判断队列是否满
        if (!isFull()) {
            arr[rear] = data;
            System.out.println("rear = " + rear);
            rear = (rear + 1) % maxSize;
        } else {
            System.out.println("队列已满！");
        }
    }

    //数据出队列
    public int getQueue() {
        if (!isEmpty()) {
            int value = arr[front];
            front = (front + 1) % maxSize;
            return value;
        }
        //如果队列为空
        throw new RuntimeException("队列为空，无法返回数据！");
    }

    //显示队列中的所有数据
    public void show() {
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        //从front开始遍历
        for (int i = front; i < front + size(); i++) {
            System.out.println("s = " + size());
            System.out.printf("arr[%d] = %d\t", i % maxSize, arr[i % maxSize]);
        }
        System.out.println();
    }

    //当前队列中有效数据的个数
    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

}
