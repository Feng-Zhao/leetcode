import javax.swing.text.AbstractDocument.LeafElement;

/*
 * @lc app=leetcode.cn id=164 lang=java
 *
 * [164] 最大间距
 */

// @lc code=start
class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        ListNode emptyHead = new ListNode(0);
        ListNode cur = emptyHead;

        for (int i = 0; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            while(cur.next != null && cur.next.val < node.val){
                cur = cur.next;
            }
            node.next = cur.next;
            cur.next = node;
        }

        ListNode p = emptyHead.next;
        int maxCost = 0;
        while(p != null){
            p.calculateCost();
            if(p.cost > maxCost){
                maxCost = p.cost;
            }
        }
        return maxCost;
    }

    class ListNode {
        int val;
        int cost;
        ListNode next;

        public ListNode(int value){
            this.val = value;
            this.next = null;
            this.cost = 0;
        }

        public void calculateCost(){
            if(this.next != null){
                this.cost = this.next.val - this.val;
            }
            else{
                this.cost = 0;
            }
        }
    }
}
// @lc code=end
