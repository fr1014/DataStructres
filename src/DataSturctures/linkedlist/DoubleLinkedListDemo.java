package DataSturctures.linkedlist;

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        LinkedNode node1 = new LinkedNode(1, "宋江", "及时雨");
        LinkedNode node2 = new LinkedNode(2, "卢俊义", "玉麒麟");
        LinkedNode node3 = new LinkedNode(3, "吴用", "智多星");
        LinkedNode node4 = new LinkedNode(4, "林冲", "豹子头");

        DoubleLinkedList linkedList = new DoubleLinkedList();
        linkedList.add(node1);
        linkedList.add(node2);
        linkedList.add(node3);
        linkedList.add(node4);
        linkedList.list();

        linkedList.delete(2);
        System.out.println("删除后的链表");
        linkedList.list();
    }
}

class DoubleLinkedList {
    //初始化双向链表的头部
    private LinkedNode head = new LinkedNode(0, "", "");

    //获取链表的头部
    public LinkedNode getHead() {
        return head;
    }

    //显示链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，所以需要一个辅助变量来遍历
        LinkedNode temp = head.next;
        while (temp != null) {
            //输出节点信息
            System.out.println(temp.toString());
            //将temp后移
            temp = temp.next;
        }
    }

    public void add(LinkedNode node) {
        LinkedNode temp = head;
        while (temp.next != null) {
            temp = temp.next;

        }
        //形成一个双向链表
        temp.next = node;  //当前节点的下一节点指向新节点
        node.pre = temp;   //新节点的上一节点指向当前节点
    }

    //修改链表节点，根据no
    public void update(LinkedNode newNode) {
        if (head.next == null) {
            System.out.println("链表为空，无法修改！");
            return;
        }
        LinkedNode temp = head.next;
        boolean flag = false; //是否找到该节点
        while (true) {
            //已到达链表最后
            if (temp == null) {
                break;
            }
            if (temp.no == newNode.no) {
                //表示已经找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newNode.name;
            temp.nickName = newNode.nickName;
        } else {
            System.out.println("此链表中没有此no");
        }
    }

    //删除节点
    public void delete(int no) {

        if (head.next == null) {
            System.out.println("无法删除，此链表为空！");
            return;
        }

        LinkedNode temp = head.next;
        boolean flag = false;
        while (true) {
            //已经到链表的最后
            if (temp == null) {
                break;
            }
            //找到待删除节点
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;  //temp后移，遍历
        }
        //如果找到该节点
        if (flag) {
            temp.pre.next = temp.next;
            //如果是最后一个节点无需执行
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("此链表中未找到要删除的节点！");
        }
    }
}

class LinkedNode {
    public int no;
    public String name;
    public String nickName; //昵称
    public LinkedNode next; //指向下一个节点
    public LinkedNode pre;  //指向前一个节点

    public LinkedNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}