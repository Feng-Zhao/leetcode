import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start
class Solution {
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

    class MyComparer implements Comparator<Node>{
        @Override
        public int compare(Node o1, Node o2){
            if(o1.start == o2.start && o1.end == o2.end){
                return 0;
            }
            else{
                return o1.start < o2.start ? -1 : 1;
            }
        }
    }


    public int[][] merge(int[][] intervals) {
        Queue<Node> myList = new PriorityQueue<>(new MyComparer());
        for (int[] i : intervals) {
            myList.add(new Node(i));
        }

        List<Node> result = new ArrayList<>();
        Node cur = myList.poll();
        while(!myList.isEmpty()){
            Node next = myList.poll();
            if(cur.end >= next.start){
                cur.start = cur.start < next.start ? cur.start : next.start;
                cur.end = cur.end > next.end ? cur.end : next.end;
            }else{
                result.add(cur);
                cur = next;
            }
        }
        result.add(cur);
        
        int[][] resultArray = new int[result.size()][2];
        for (int i = 0; i < resultArray.length; i++) {
            resultArray[i] = result.get(i).toArray();
        }
        return resultArray;
    }
}
// @lc code=end

