
/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int end = height.length -1;

        for(int i = 0; i < end; i++){
            max =  updateMax(height,max,i,end);
        } 

        return max;
    }

    private int updateMax(int[] nums, int max, int start, int end){
        while( end > start ){
            int height = nums[start] < nums[end] ? nums[start] : nums[end];
            max = max < height * (end-start)  ? height * (end-start) : max;
            end--;
        }
        return max;
    }
}
// @lc code=end

