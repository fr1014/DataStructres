package DataSturctures.stack;

public class ArrayStackDemo {

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(6);
        stack.push(1);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.show();
    }
}

class ArrayStack {
    private int maxSize; //栈的大小
    private int[] stack; //数组模拟栈
    private int top = -1; //表示栈顶

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈满
    public Boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public Boolean isEmpty() {
        return top == -1;
    }

    public void push(int num) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = num;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("栈空");
            return 0;
        }
        int value = stack[top];
        top--;
        return value;
    }

    public void show() {
        if (isEmpty()){
            System.out.println("栈空，无数据");
            return;
        }

        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n",i,stack[i]);
        }
    }
}