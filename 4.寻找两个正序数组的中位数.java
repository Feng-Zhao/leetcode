

import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=4 lang=java
 *
 * [4] 寻找两个正序数组的中位数
 */

// @test([1,2,3],[4,5,6])=3.5
// @lc code=start
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int aLeft = 0;
        int aRight = nums1.length - 1;

        int bLeft = 0;
        int bRight = nums2.length - 1;

        int L;
        int R;

        while(true){
            // nums1 耗尽
            if(aLeft > aRight){
                int[] target = Arrays.copyOfRange(nums2, bLeft, bRight+1);
                return getMiddel(target);
            }
            // nums2 耗尽
            else if (bLeft > bRight ){
                int[] target = Arrays.copyOfRange(nums1, aLeft, aRight+1);
                return getMiddel(target);
            }
            else if( (nums1.length + nums2.length) % 2 == 0 && aLeft == aRight && bLeft == bRight){
                return ( nums1[aLeft] + nums2[bLeft] + 0.0 ) / 2;
            }

            L = nums1[aLeft] <= nums2[bLeft] ? ++aLeft : ++bLeft;
            R = nums1[aRight] >= nums2[bRight] ? --aRight : --bRight;
            
            
        }
    }

    // assumes that the array will never be empty and the nums is sorted
    private double getMiddel(int[] nums){
        if(nums.length % 2 == 0){
            return ( nums[nums.length / 2 -1] + nums[nums.length/2] ) / 2.0;
        }else{
            return nums[nums.length / 2];
        }
    }
}
// @lc code=end

