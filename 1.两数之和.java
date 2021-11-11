import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int[] result = new int[2];
        int left;
        for (int i = 0; i < nums.length; i++) {
            // 计算所需值
            left = target - nums[i];
            // 若map中有此值，组合为返回结果
            if (map.get(left) != null && i != map.get(left)) {
                result[0] = i;
                result[1] = map.get(left);
                return result;
            }
        }
        return null;
    }
}
// @lc code=end
