import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=217 lang=java
 *
 * [217] 存在重复元素
 */

// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // return byHashMap(nums);
        return byStream(nums);
        // return byBitMap(nums);
    }

    private boolean byHashMap(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i], true);
        }
        return false;
    }

    private boolean byStream(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }

    /**
     * BitMap + offet for negative number
     * need to know the range! and
     * 
     */
    int range = (int) Math.round(Math.pow(2, 18));

    private boolean byBitMap(int[] nums) {
        byte[] mark = new byte[2 * range];
        for (int i : nums) {
            int j = i / 8 + range;
            int k = (i % 8 + 8) % 8;
            int check = 1 << k;
            if ((mark[j] & check) != 0) {
                return true;
            }
            mark[j] |= check;
        }
        return false;
    }

}
// @lc code=end
