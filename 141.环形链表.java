/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode quick = head.next;
        ListNode slow = head;
        while(quick != null){
            if(quick == slow){
                return true;
            }
            if(quick.next != null){
                quick = quick.next.next;
            }
            else{
                quick = quick.next;
            }
            slow = slow.next;
        }
        return false;
    }
}
// @lc code=end

