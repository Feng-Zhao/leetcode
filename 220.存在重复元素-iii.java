import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=220 lang=java
 *
 * [220] 存在重复元素 III
 */

// @lc code=start
class Solution {
    // 暴力解法_超时
    // public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    //     for (int i = 0; i < nums.length; i++) {
    //         int cur = i - k < 0 ? 0 : i - k;
    //         while (cur < i) {

    //             if (Math.abs((long) nums[cur] - (long) nums[i]) <= t) {
    //                 return true;
    //             }
    //             cur++;
    //         }
    //     }
    //     return false;
    // }

    // 利用桶结构
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for (int i = 0; i < nums.length; i++) {
            if(i > k){
                
            }
        }
    }

}
// @lc code=end
