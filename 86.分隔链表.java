import java.util.LinkedList;


/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode minList = new ListNode();
        ListNode maxList = new ListNode();
        ListNode cur = head;
        ListNode minPos = minList;
        ListNode maxPos = maxList;
        while(cur != null){
            if(cur.val < x){
                minPos.next = cur;
                minPos = minPos.next;
            }
            else{
                maxPos.next = cur;
                maxPos = maxPos.next;
            }
            cur = cur.next;
        }
        maxPos.next = null;
        minPos.next = maxList.next;
        return minList.next;
    }
}
// @lc code=end

