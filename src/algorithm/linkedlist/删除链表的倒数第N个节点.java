package algorithm.linkedlist;

public class 删除链表的倒数第N个节点 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode node = removeNthFromEnd(l1, 2);
        node.sys();
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;

        ListNode node = new ListNode(0);
        node.next = head;

        int length = 0;
        ListNode l1 = head;
        while(l1 != null){
            length++;
            l1 = l1.next;
        }

        length = length - n;
        l1 = node;
        while(length > 0){
            length--;
            l1 = l1.next;
        }
        l1.next = l1.next.next;
        return node.next;
    }
}
