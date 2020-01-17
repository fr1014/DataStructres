package DataSturctures.queue;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);
        queue.addQueue(1);
        queue.addQueue(2);
        queue.addQueue(4);
        queue.show();
        System.out.println(queue.getQueue());
        System.out.println(queue.getQueue());
    }
}

class ArrayQueue {
    private int maxSize; //表示数组的最大容量
    private int rear; //尾指针（队列尾）
    private int front; //头指针（队列头）
    private int[] arr; //该数组用于存放数据，模拟队列

    //创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列的头部
        rear = -1;  //指向队列的尾部
    }

    //判断队列是否已满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int data) {
        //判断队列是否满
        if (!isFull()) {
            rear++;     //rear后移
            arr[rear] = data;
        }
    }

    //数据出队列
    public int getQueue() {
        if (!isEmpty()) {
            front++;
            return arr[front];
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
        for (int value : arr) {
            System.out.printf("%d\t", value);
        }
        System.out.println();
    }

}
