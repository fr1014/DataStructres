package algorithm;

public class 两数相加 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode node = new 两数相加().addTwoNumbers(l1, l2);
    }

    /**
     * 各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字
     * 如果, 将这两个数相加起来，则会返回一个新的链表来表示它们的和
     *
     * @param l1 非空的链表用来表示非负的整数 (2 -> 4 -> 3)
     * @param l2 非空的链表用来表示非负的整数 (5 -> 6 -> 4)
     * @return 7 -> 0 -> 8
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        //用cur来移动链表的next
        ListNode p = l1, q = l2, cur = l3;
        int carry = 0;  //进位 1 或 0
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p != null) {
                p = p.next;
            }
            if (q != null) {
                q = q.next;
            }
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return l3.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
