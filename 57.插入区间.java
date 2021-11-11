import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            int[][] result = new int[1][2];
            result[0] = newInterval;
            return result;
        } else {
            int[][] result = new int[intervals.length + 1][2];
            // List<Node> list = new LinkedList<>();

            int newStart = newInterval[0];
            int newEnd = newInterval[1];

            int i = 0;
            int cur = 0;
            while (i < intervals.length && intervals[i][1] < newInterval[0]) {
                // list.add(new Node(intervals[i]));
                result[cur++] = intervals[i++];
            }
            if(i < intervals.length ){// not finished
                // update new start
                newStart = intervals[i][0] < newInterval[0] ? intervals[i][0] : newInterval[0];

                // update new end
                while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
                    newEnd = intervals[i][1] > newInterval[1] ? intervals[i][1] : newInterval[1];
                    i++;
                }
                // merge
                int[] newIns = { newStart, newEnd };
                // insert new interval
                result[cur++] = newIns;

                // append the rest intervals
                while (i < intervals.length) {
                    result[cur++] = intervals[i++];
                }
            }
            else{// finished
                // append newInterval to the tail
                result[cur++] = newInterval;
            }
            return Arrays.copyOf(result, cur);
        }
    }
}
// @lc code=end
