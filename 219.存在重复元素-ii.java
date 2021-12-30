import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * @lc app=leetcode.cn id=219 lang=java
 *
 * [219] 存在重复元素 II
 */

// @lc code=start
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,ListNode> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])){
                ListNode check = map.get(nums[i]);
                while(check!=null){
                    if(i-check.pos <= k){
                        return true;
                    }
                    check = check.next;
                }
                ListNode newNode = new ListNode(nums[i],i);
                newNode.next = map.get(nums[i]);
                map.put(nums[i], newNode);
            }
            else{
                ListNode newNode = new ListNode(nums[i],i);
                map.put(nums[i], newNode);
            }
        }
        return false;
    }

//     public boolean containsNearbyDuplicate(int[] nums, int k) {
//         Set<Integer> set = new HashSet<Integer>();
//         for(int i = 0; i < nums.length; i++){
//             if(i > k) set.remove(nums[i-k-1]);
//             if(!set.add(nums[i])) return true;
//         }
//         return false;
//      }

    class ListNode{
        int val;
        int pos;
        ListNode next;

        ListNode(int val,int pos){
            this.val = val;
            this.pos = pos;
            this.next = null;
        }
    }
}
// @lc code=end

