/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tailA = headA;
        ListNode tailB = headB;
        int lenA = 0;
        int lenB = 0;
        while(tailA.next != null){
            tailA = tailA.next;
            lenA++;
        }
        while(tailB.next != null){
            tailB = tailB.next;
            lenB++;
        }

        if(tailA != tailB){
            return null;
        }

        int dif = lenA-lenB;
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while(dif != 0){
            if(dif > 0){
                nodeA = nodeA.next;
                dif--;
            }
            else{
                nodeB = nodeB.next;
                dif++;
            }
        }
        while(nodeA != nodeB){
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        return nodeA;
    }
}
// @lc code=end

