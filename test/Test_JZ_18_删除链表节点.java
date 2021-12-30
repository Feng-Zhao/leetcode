package test;

public class Test_JZ_18_删除链表节点 {
    public static ListNode deleteNode(ListNode head, int val) {
        if(head.val == val){
            return head.next;
        }
        ListNode cur = head;
        while(cur.next != null){
            if(cur.next.val == val){
                cur.next = cur.next.next;
                return head;
            }
            cur = cur.next;
        }
        return head;
        
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(5);
        ListNode c = new ListNode(-99);
        a.next = b;
        b.next = c;
        c.next = null;
        ListNode head = deleteNode(a,-99);
        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
