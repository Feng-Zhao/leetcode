import java.util.HashMap;
import java.util.Map;

public class TestMain {
    Solution solution = new Solution();

    // class ListNode {
    //     int val;
    //     ListNode next;

    //     ListNode() {
    //     }

    //     ListNode(int val) {
    //         this.val = val;
    //     }

    //     ListNode(int val, ListNode next) {
    //         this.val = val;
    //         this.next = next;
    //     }
    // }
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            return byBitMap(nums);
        }

        int range = (int)Math.round(Math.pow(2, 29));
        private boolean byBitMap(int[] nums) {
            byte[] mark = new byte[2*range];
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

    public static void main(String[] args) {
        TestMain t = new TestMain();

        // == parameter ===============================

        // =================================
        // int[] b =  {7,1,4,5,3,6,8,7,9,2,0,11,33,23,41,56,886,4,23,56,4,23,465,8234,56134565,12,345,16,74,24,5687,21,455,768,345,2546,2456,245234,2552234,3,1435,2436,2345,324,5,6245,62,456,345,34,6,245,0,4,56,4,2};
        // int[] b = {2,0,2,1,1,0};
        int[] b = {-3574995,-3574995};

        // ListNode head = new ListNode(4);
        // ListNode cur = head;
        // cur.next = new ListNode(2);
        // cur = cur.next;
        // cur.next = new ListNode(1);
        // cur = cur.next;
        // cur.next = new ListNode(3);


        boolean flag = t.solution.containsDuplicate(b);
        System.out.println(flag);

        // while(head != null){
        //     System.out.println(head.val);
        //     head = head.next;
        // }
        
    }
}
