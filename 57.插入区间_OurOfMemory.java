import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // pre-result
        List<Node> list = new ArrayList<>();
        List<Node> result = new ArrayList<>();
        // 非空检查
        if(intervals == null || intervals.length == 0){
            list.add(new Node(newInterval));
        }
        // logic
        else{
            for (int i = 0; i < intervals.length; i++) {
                
                list.add(new Node(intervals[i]));
                
            }

            int newStart;
            int newEnd = Integer.MIN_VALUE;

            int i = 0;
            while(i < list.size() && list.get(i).end < newInterval[0] ){
                result.add(list.get(i));
                i++;
            }

            // set new start
            newStart = list.get(i).start < newInterval[0] ? list.get(i).start : newInterval[0];

            // update new end
            while(i < list.size() && list.get(i).start <= newInterval[1] ){
                newEnd = list.get(i).end > newInterval[1] ?  list.get(i).end  : newInterval[1];
                i++;
            }
            // merge
            int[] newIns = {newStart,newEnd};
            result.add(new Node(newIns));
            // fill the rest intervals
            while(i < list.size()){
                result.add(list.get(i));
            }
        }

        // parse to int[][]
        int[][] finalResult = new int[result.size()][2];
        for (int i = 0; i < finalResult.length; i++) {
            finalResult[i] = result.get(i).toArray();
        }
        return finalResult;
    }




    class Node {
        int start;
        int end;

        public Node (int[] nums){
            this.start = nums[0];
            this.end = nums[1];
        }

        public int[] toArray(){
            int[] i = {start,end};
            return i;
        }
    }
}
// @lc code=end

