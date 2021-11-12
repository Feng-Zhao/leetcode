import TestMain.ListNode;

/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null){
            return head;
        }

        ListNode emptyHead = new ListNode(0,head);
        ListNode pre_tail = head;
        ListNode tail = head.next;
        while(tail != null ){
            ListNode pre_cur = emptyHead;
            ListNode cur = pre_cur.next;
            boolean movePreTail = true;
            while(cur != tail){
                if(cur.val <= tail.val){
                    cur = cur.next;
                    pre_cur = pre_cur.next;
                }
                else{
                    pre_cur.next = tail;
                    pre_tail.next = tail.next;
                    tail.next = cur;

                    
                    if(pre_tail.next != null && pre_tail.next.val > tail.val){
                        pre_cur = pre_cur.next;
                        tail = pre_tail.next;
                    }
                    else{
                        movePreTail = false;
                        break;
                    }
                }
            }
            if(movePreTail){
                pre_tail = pre_tail.next;
            }
            tail = pre_tail.next;
        }
        return emptyHead.next;
    }

    // public ListNode insertionSortList(ListNode head) {
    //     if( head == null ){
    //         return head;
    //     }
        
    //     ListNode helper = new ListNode(0); //new starter of the sorted list
    //     ListNode cur = head; //the node will be inserted
    //     ListNode pre = helper; //insert node between pre and pre.next
    //     ListNode next = null; //the next node will be inserted
    //     //not the end of input list
    //     while( cur != null ){
    //         next = cur.next;
    //         //find the right place to insert
    //         while( pre.next != null && pre.next.val < cur.val ){
    //             pre = pre.next;
    //         }
    //         //insert between pre and pre.next
    //         cur.next = pre.next;
    //         pre.next = cur;
    //         pre = helper;
    //         cur = next;
    //     }
        
    //     return helper.next;
    // }

    // class ListNode {
    //     int val;
    //     ListNode next;

    //     ListNode() {
    //     }

    //     ListNode(int val) {
    //         this.val = val;
    //     }

    //     ListNode(int val, ListNode next) {
    //         this.val = val;
    //         this.next = next;
    //     }
    // }
}
// @lc code=end
