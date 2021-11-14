import java.util.List;

/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode slow = head;
        ListNode quick = head;
        ListNode leftEnd = null;
        while(quick != null && quick.next != null){
            leftEnd = slow;
            slow = slow.next;
            quick = quick.next.next;
        }
        leftEnd.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(slow);


        return merge(left,right);
    }

    private ListNode merge(ListNode left,ListNode right){
        ListNode emptyHead = new ListNode(0);
        ListNode cur = emptyHead;
        while(left != null && right != null){
            if(left.val < right.val){
                cur.next = left;
                left = left.next;
            }
            else{
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;
        }
        if(left != null){
            cur.next = left;
        }
        if(right != null){
            cur.next = right;
        }
        return emptyHead.next;
    }
}
// @lc code=end

