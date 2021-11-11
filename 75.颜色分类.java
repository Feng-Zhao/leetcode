import java.lang.System.LoggerFinder;
import java.util.Arrays;
import java.util.function.LongFunction;

/*
 * @lc app=leetcode.cn id=75 lang=java
 *
 * [75] 颜色分类
 */

// @lc code=start
class Solution {
    public void sortColors(int[] nums) {
        if (nums.length <= 1) {
            return;
        } else {
            // 针对本题
            // pass1way(nums);

            // 通用排序算法
            // bubbleSort(nums); // 冒泡排序
            // selectSort(nums); // 选择排序
            // insertSort(nums); // 插入排序
            // quickSort(nums); // 快速排序
            // shellSort(nums); // 希尔排序

            int[] sorted = mergeSort(nums); // 2路归并排序
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sorted[i];
            }
        }

    }

    // ========== 针对本题的解法 =========================================================

    // 遍历一次 从左右分别填写 0， 2
    private void pass1way(int[] nums) {
        // 下一个0的位置
        int p0 = 0;
        // 下一个2的位置
        int p2 = nums.length - 1;
        // 当前位置
        int cur = 0;
        while (cur <= p2) {
            if (nums[cur] == 0) {
                nums[cur] = nums[p0];
                nums[p0] = 0;
                p0++;
                // p0 永远滞后于 cur ,所以换过来的东西都是以前已经见过的元素，不用再次处理
                cur++;
            } else if (nums[cur] == 2) {
                nums[cur] = nums[p2];
                nums[p2] = 2;
                p2--;
                // p2 换过来的元素都是未见过的，所以需要cur停留再原地，再次处理nums[cur]
            } else {
                // 1 的情况，不用处理，以后会被后边的 0 换走
                cur++;
            }
        }
    }

    // 遍历1.5次 快慢指针
    private void passOneHalfway(int[] nums) {
        // 1.5-pass
        // int left0 = 0;
        int left1 = 0;
        // int left2 = 0;

        int quick = 0;
        int slow = 0;
        while (slow < nums.length) {
            if (quick < nums.length) {
                switch (nums[quick]) {
                case 0: {
                    nums[slow] = 0;
                    slow++;
                    quick++;
                    break;
                }
                case 1: {
                    left1++;
                    quick++;
                    break;
                }
                case 2: {
                    quick++;
                    break;
                }
                default:
                    throw new RuntimeException();
                }
            } else {
                if (left1 > 0) {
                    nums[slow] = 1;
                    slow++;
                    left1--;
                } else {
                    nums[slow] = 2;
                    slow++;
                    // left2--;
                }
            }
        }
    }

    // 遍历两次，第一次统计，第二次赋值, 最符合自然逻辑的方式
    private void pass2way(int[] nums) {
        // 2-pass
        int count0 = 0, count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
            }
            if (nums[i] == 1) {
                count1++;
            }
            if (nums[i] == 2) {
                count2++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < count0) {
                nums[i] = 0;
            } else if (i < count0 + count1) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }

    // ========== 通用排序算法 ===========================================================

    // ============= 交换操作 ==========================================

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    // !!!! 重要当 a = b 时 异或交换两个数会置零
    // 只应该在极限要求缩小空间使用时才使用.
    private void swapForBubble(int[] nums, int a, int b) {
        // 三次异或 交换 AB
        // A ^ A = 0
        // A ^ 0 = A
        if (a == b) {
            return;
        }
        nums[a] = nums[a] ^ nums[b]; // nums[a] = A ^ B
        nums[b] = nums[a] ^ nums[b]; // nums[b] = A ^ B ^ B = A
        nums[a] = nums[a] ^ nums[b]; // nums[a] = A ^ B ^ A = B
    }
    // ===================================================================

    // ============= 冒泡排序 ===========================================
    /**
     * 冒泡排序性能: 数据完全有序的情况下是 **O(n)**, 通常情况下为 **O(n^2)**
     * 
     * 
     * 冒泡排序可优化技术 1. 增加 swap 标识, 当上一轮没有发生交换时,表示这时数组已经有序,停止冒泡 ```java for (int i =
     * arr.length - 1; i > 0; i--) { // 每次需要排序的长度 swap=false; for (int j = 0; j < i;
     * j++) { // 从第一个元素到第i个元素 if (arr[j] > arr[j + 1]) { temp = arr[j]; arr[j] =
     * arr[j + 1]; arr[j + 1] = temp; swap=true; } }//loop j if (swap==false){
     * break; } }//loop i ```
     * 
     * 2. 鸡尾酒排序法,双向冒泡,向右冒泡一次,然后向左冒泡, 这种优化的地方在于向右冒泡时的交换 对于向左交换也有效,即大的交换小的 =
     * 小的交换大的,减少了总体的交换次数 ```java public static void cocktailSort(int[] arr) { int L
     * = 0,R = arr.length-1; while(L < R) { for(int i = L; i < R; i++) if(arr[i] >
     * arr[i+1]) swap(arr,i,i+1); R--; for(int i = R; i > L; i--) if(arr[i] <
     * arr[i-1]) swap(arr,i,i-1); L++; } } ```
     */
    private void bubbleSort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swapForBubble(nums, j, j + 1);
                }
            }
        }

    }
    // ============= 冒泡排序 end ======================================

    // ============= 选择排序 ===========================================
    /**
     * 选择排序性能: 固定 O(n^2)
     * 
     */
    private void selectSort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            int max = nums[i];
            int pos = i;
            for (int j = 0; j < i; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                    pos = j;
                }
            }
            if (pos != i) {
                swap(nums, i, pos);
            }
        }
    }

    // ============= 选择排序 end ======================================

    // ============= 插入排序 ===========================================
    /**
     * 性能 O(n^2) 大多数场景下比冒泡好一点,比选择排序稍稍好一点,有的地方做为快速排序的补充
     * 
     * 优化: 在查找插入位置时,不从后向前找,改用二分查找
     * 
     */
    private void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            int temp = nums[j];
            while (j > 0 && temp < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }
            nums[j] = temp;
        }
    }
    // ============= 插入排序 end ======================================

    // ============= 快速排序 ===========================================

    /**
     * 时间复杂度：最好：O(nlogn) 最差： O(n^2) 平均：O(nlogn) 空间复杂度：
     * 在原有数组上排序，额外空间为常量级O(1)。但是递归调用的栈空间，平均为O(logn),最差(每次分区只完成一个数) 为 O(n) 每次选定一个轴
     * pivot
     */
    private void quickSort(int[] nums) {
        qsort(nums, 0, nums.length - 1);
    }

    private void qsort(int[] nums, int left, int right) {
        if (left >= right) {// 终止条件，当左边界与右边界 相遇(即只有数组长度为 1) 或 超过右边界时
            return;
        }
        int pivot = partition1(nums, left, right);
        qsort(nums, left, pivot - 1);
        qsort(nums, pivot + 1, right);
    }

    /**
     * 左右交换法，设置一个闲置位置，分别从左右两边寻找目标数，与闲置位置交换，知道扫描完成 最后pivot 与闲置位置交换，完成一次partion
     */
    private int partition1(int[] nums, int left, int right) {
        int pivot = nums[left];// 标记pivot, 此时left为闲置位置，可用于交换
        while (left < right) {
            // 从右向左，找到比pivot小的数，将此位置的数与闲置位置交换；此时right标记位置变为闲置位置
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];

            // 从左向右，找到比pivot大的数，将此位置的数与闲置位置交换；此时left标记位置变为闲置位置
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }
        // 最终
        nums[left] = pivot;
        return left;
    }

    /**
     * 快慢指针法，快指针寻找比左侧数，将找到的数字与慢指针位置交换，完成一次扫描后 慢指针所知位置以前均为比 pivot 小的数字，将pivot交换到 slow
     * + 1 位置完成partition
     */
    private int partition2(int[] nums, int left, int right) {
        int pivot = nums[right];
        int slow = left - 1;
        int quick = left;
        while (quick < right) {
            if (nums[quick] < pivot) {
                slow++;
                swap(nums, quick, slow);
            }
            quick++;
        }
        swap(nums, slow + 1, right);
        return slow + 1;
    }
    // ============= 快速排序 end ======================================

    // ============= 希尔排序 ==========================================
    /**
     * 步进式排序：步数由大到小最终步数为1时，排序完成
     */
    private void shellSort(int[] nums) {
        int len = nums.length;
        int gap = 1;
        while (gap < len / 3) {
            gap = gap * 3 + 1;
        }
        while (gap > 0) {// 逐渐缩小步数
            // 对每个分组
            for (int offset = 0; offset < gap; offset++) {
                // 每个分组内进行插入排序，此处可以将这个for 和 上一个for合并
                // 变为轮流对每个分组比较一次，简化代码，此处为了便于理解，保留分组操作

                // 即可以从 a,a,a,a, | b,b,b,b, | c,c,c,c, | d,d,d,d 的比较次序变为
                // a,b,c,d, | a,b,c,d, | a,b,c,d，| a,b,c,d, | a,b,c,d
                for (int i = offset + gap; i < len; i += gap) {
                    int j = i;
                    int temp = nums[j];
                    while (j > offset && temp < nums[j - gap]) {
                        nums[j] = nums[j - gap];
                        j -= gap;
                    }
                    if (j > offset) {
                        nums[j] = temp;
                    } else {
                        nums[offset] = temp;
                    }
                }
            }
            gap = gap / 3;
        }
    }
    // ============= 希尔排序 end ======================================

    // ============= 归并排序 ==========================================
    /**
     * 性能: O(nlogn) 需要额外空间
     * 
     */
    private int[] mergeSort(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }
        int[] left = Arrays.copyOfRange(nums, 0, nums.length / 2);
        int[] right = Arrays.copyOfRange(nums, nums.length / 2, nums.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    private int[] merge(int[] left, int[] right) {
        int lp = 0;
        int rp = 0;
        int[] newArray = new int[left.length + right.length];
        int cur = 0;
        while (cur < newArray.length) {
            if (lp == left.length) {
                newArray[cur] = right[rp];
                rp++;
            } else if (rp == right.length) {
                newArray[cur] = left[lp];
                lp++;
            } else if (left[lp] <= right[rp]) {
                newArray[cur] = left[lp];
                lp++;
            } else {
                newArray[cur] = right[rp];
                rp++;
            }
            cur++;
        }

        return newArray;
    }
    // ============= 归并排序 end ======================================

    // ============= 堆排序 ======================================
    /**
     * 二叉树性质: 父节点 i , 左孩子为 2i+1,右孩子为 2i+2 子节点为 i, 父节点为 ( (i+1) / 2 ) - 1
     * 
     */
    private void heapSort(int[] nums) {

    }

    private void buildHeap(int[] nums) {
        // 最后一个叶子节点的父节点开始
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            int cur = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (left < nums.length && nums[left] > nums[cur]) {
                cur = left;
            }
            if (right < nums.length && nums[right] > nums[cur]) {
                cur = right;
            }
            if (cur != i) {
                swap(nums, cur, i);
            }
        }
    }

    private void heapify(int[] nums, int len, int pos) {
        int cur = pos;
        int left = 2 * pos + 1;
        int right = 2 * pos + 2;
        if (left < len && nums[left] > nums[cur]) {
            cur = left;
        }
        if (right < len && nums[right] > nums[cur]) {
            cur = right;
        }
        if (cur != pos) {
            swap(nums, cur, pos);
            heapify(nums, len, cur);
        }
    }
    // ============= 堆排序 end ======================================
}
// @lc code=end
