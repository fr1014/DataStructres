package algorithm.linkedlist;

public class 反转单链表 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.setNext(n2);
        n2.setNext(n3);

        System.out.println(reverseList(n1));;
    }

    /**
     * @param head 需要反转的链表头
     * @return 已反转的链表的头
     */
    public static ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode reverseHead = null; //反转后的链表头
        ListNode cur = head; //当前节点
        ListNode next = null; //保存当前节点的下一节点
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead;
            reverseHead = cur;
            cur = next;
        }
        return reverseHead;
    }
}

class ListNode {
    private int val;
    public ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }

    public void sys(){
        if (next!=null){
            System.out.print(val + "——>");
        }else {
            System.out.print(val);
        }
       if (next != null){
           next.sys();
       }
    }
}
