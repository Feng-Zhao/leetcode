/*
 * @lc app=leetcode.cn id=31 lang=java
 *
 * [31] 下一个排列
 */

// @lc code=start
class Solution {
    public void nextPermutation(int[] nums) {
        int sorted = nums.length -1;
        int cur = sorted - 1;
        int start = 0;
        // 找到第一次交换位置
        while (sorted > start){
            if(cur < 0){
                sorted--;
                cur = sorted - 1;
            }
            else if(nums[cur] < nums[sorted]){
                int temp = nums[sorted];
                nums[sorted] = nums[cur];
                nums[cur] = temp;
                start = cur+1;
            }
            else{
                cur--;
            }
        }
        // 从第一次交换位置 到结尾升序排列
        // 由于题目要求,第一次交换位置到结尾一定是降序的
        // 所以只要来回交换头尾,直到头尾相遇即可
        int stop = nums.length -1;
        while(start < stop){
            int temp = nums[stop];
            nums[stop] = nums[start];
            nums[start] = temp;
        }
        
    }
}
// @lc code=end