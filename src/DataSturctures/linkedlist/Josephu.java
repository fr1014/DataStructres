package DataSturctures.linkedlist;

public class Josephu {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoys();
        circleSingleLinkedList.countBoy(1,2,5);
    }

}

//创建一个环形链表
class CircleSingleLinkedList {
    //创建第一个first节点，当前没有编号
    Boy first = null;

    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("人数不能小于1");
            return;
        }
        Boy curBoy = null; //辅助指针，帮助构成环形链表
        //使用for循环构成环形链表
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first); //构成环形
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历当前的环形链表
    public void showBoys() {
        if (first == null) {
            System.out.println("没有小孩");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.println("小孩：" + curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }
            curBoy = curBoy.getNext();
        }

    }

    /**
     * @param startNum k
     * @param countNum m
     * @param nums     开始时小孩总数
     */
    public void countBoy(int startNum, int countNum, int nums) {
        if (first == null || startNum < 1 || startNum > nums) {
            System.out.println("输入的数据有误！");
            return;
        }
        Boy helper = first;
        //创建一个辅助节点helper，指向最后一个节点
        while (helper.getNext() != first) {
            helper = helper.getNext();
        }

        //小孩报数前，移动first和helper到startNum-1位置
        for (int i = 0; i < startNum - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        //开始报数
        while (helper != first) {
            //开始报数
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            //此时first指向的节点就是要出圈的小孩
            System.out.printf("小孩%d出圈\n", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩%d\n", first.getNo());
    }
}

//创建Boy类，表示一个节点
class Boy {
    private int no; //小孩编号
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
