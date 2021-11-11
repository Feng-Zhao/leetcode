
/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    class Status {
        public int max;
        public int lastLeft;
    }

    public int maxArea(int[] height) {
        Status s = new Status();
        s.max = 0;
        s.lastLeft = 0;

        int end = height.length - 1;

        for (int i = 0; i < end; i++) { // 搜索 i -> end之间的最大值
            if (height[i] > s.lastLeft) {
                updateMax(height, s, i, end); // 以 i 为左边， 搜索最大值
                s.lastLeft = height[i];
            }
        }

        return s.max;
    }

    // 以 i 为左边， 搜索最大值
    private void updateMax(int[] nums, Status s, int start, int end) {
        int last_end = 0;
        while (start < end) {
            if (nums[end] > last_end) {
                // 取高
                int high = nums[start] < nums[end] ? nums[start] : nums[end];
                // 若 体积更大 则更新 max
                if (s.max < high * (end - start)) {
                    s.max = high * (end - start);
                    last_end = nums[end];
                }
            }
            end--;
        }
    }
}
// @lc code=end
