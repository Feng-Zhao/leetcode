/*
 * @lc app=leetcode.cn id=164 lang=java
 *
 * [164] 最大间距
 */

// @lc code=start
class Solution {
    public int maximumGap(int[] nums) {
        if(nums.length < 2){
            return 0;
        }

        Node head = new Node(nums[0]);
        Node cur;
        for (int i = 1; i < nums.length; i++) {
            cur = head;
            Node node = new Node(nums[i]);
            if(nums[i] > cur.val){
                while(cur.right != null && cur.right.val < nums[i]){
                    cur = cur.right;
                }
                node.right = cur.right;
                cur.right = node;
            }
            else{
                while(cur.left != null && cur.left.val > nums[i]){
                    cur = cur.left;
                }
                node.left = cur.left;
                cur.left = node;
            }
        }

        int max = 0;
        cur = head;
        while(cur.left != null){
            if(cur.val - cur.left.val > max){
                max = cur.val - cur.left.val;
            }
        }
        cur = head;
        while(cur.right != null){
            if(cur.right.val - cur.val > max){
                max = cur.right.val - cur.val;
            }
        }
        
        return max;
    }

    class Node{
        Node left;
        Node right;
        int val;

        Node(int value){
            this.val = value;
            this.left = null;
            this.right = null;
        }
    }
}
// @lc code=end

