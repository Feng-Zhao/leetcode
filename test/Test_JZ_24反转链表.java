package test;

public class Test_JZ_24反转链表 {
    public static ListNode reverseList1(ListNode head) {
        ListNode first = head;
        ListNode cur = first.next;
        ListNode newHead = head;
        while(cur != null){
            first.next = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = first.next;
        }
        return newHead;
    }


    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        ListNode x = reverseList1(a);
        while(x!=null){
            System.out.println(x.val);
            x=x.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}