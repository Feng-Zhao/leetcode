import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=179 lang=java
 *
 * [179] 最大数
 */

// @lc code=start
class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] strs = new String[nums.length];


        Queue<String> q = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String i, String j) {
                String s1 = i+j;
                String s2 = j+i;
                // 降序排列
                return -s1.compareTo(s2);
            }
        });

        for (int i = 0; i < nums.length; i++) {
            q.add(nums[i]+"");
        }

         if(q.peek().charAt(0)=='0') return "0";

        String res = new String();
        while(!q.isEmpty()){
            res += q.poll();
        }
        return res;
    }

    // [75,81,0,68,91,84,38,15,4,36,8,0,0,4]

    // offical answer --> Arrays.sort + comparator
    public String largestNumber_offical(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = nums[i]+"";
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String i, String j) {
                String s1 = i+j;
                String s2 = j+i;
                return s1.compareTo(s2);
            }
        });
        if (strs[strs.length-1].charAt(0) == '0') return "0";
        String res = new String();
        for (int i = 0; i < strs.length; i++) {
            res = strs[i]+res;
        }
        return res;
    }
}
// @lc code=end

