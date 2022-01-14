package test;

public class Test_JZ_40最小k个数_堆 {
    public int[] getLeastNumbers(int[] arr, int k) {
        // 堆排序
        for (int i = arr.length / 2 - 1; i >= 0 ; i--) {
            heapfy(arr,i,arr.length);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[0];
            swap(arr,0,arr.length-1-i);
            heapfy(arr,0, arr.length-1-i);
        }
        return res;
    }

    void heapfy(int[] arr, int pos, int len){
        int min = pos;
        if(pos*2+1 < len && arr[min] > arr[pos*2+1]){
            min = pos*2+1;
        }
        if(pos*2+2 < len && arr[min] > arr[pos*2+2]){
            min = pos*2+2;
        }
        if(min != pos){
            swap(arr,min,pos);
            heapfy(arr,min,len);
        }
    }
    void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static void main(String[] args) {
        int[] a = {15,687,63,21,8,74,89,41,341,64,6,43,45,43,132,1,54,13,1,32,1};
        int k = 5;
        Test_JZ_40最小k个数_堆 solution = new Test_JZ_40最小k个数_堆();
        int[] res = solution.getLeastNumbers(a, k);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
