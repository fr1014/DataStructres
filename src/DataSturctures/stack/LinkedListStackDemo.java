package DataSturctures.stack;

public class LinkedListStackDemo {

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        stack.push(1);
        stack.push(2);
        stack.showStack();
        stack.pop();
        stack.showStack();
    }
}

class LinkedListStack<T> {

    private int nums; //栈中的数量
    private LinkedList<T> top;//栈顶元素

    //入栈
    public void push(T data) {
        LinkedList<T> oldTop = top;
        LinkedList<T> newTop = new LinkedList<>();
        newTop.setData(data);
        top = newTop;
        newTop.setNext(oldTop);
        nums++;
    }

    //出栈
    public T pop(){
        if (nums == 0){
            throw new RuntimeException("栈空");
        }
        LinkedList<T> oldTop = top;
        T data = oldTop.getData();
        top = oldTop.getNext();
        oldTop = null;
        nums--;
        return data;
    }

    public void showStack(){
       for (LinkedList node = top;node!= null;node = node.getNext()){
           System.out.println(node.getData());
       }
    }
}

class LinkedList<T> {
    private T data;
    private LinkedList next;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LinkedList getNext() {
        return next;
    }

    public void setNext(LinkedList next) {
        this.next = next;
    }
}