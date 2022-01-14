import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        LinkedList<ListNode> queue = new LinkedList<>();
        ListNode quick = head;
        ListNode slow = head;
        while(k > 0){
            if(quick.next != null){
                quick = quick.next;
            }
            else{
                quick = head;
            }
            k--;
        }
        while(quick.next != null){
            quick = quick.next;
            slow = slow.next;
        }
        ListNode cur = slow.next;
        slow.next = null;
        while(cur != null){
            queue.offer(cur);
            cur = cur.next;
        }
        ListNode emptyHead = new ListNode();
        cur = emptyHead;
        while(!queue.isEmpty()){
            cur.next = queue.poll();
            cur = cur.next;
        }
        cur.next = head;
        return emptyHead.next;
    }
}
// @lc code=end

