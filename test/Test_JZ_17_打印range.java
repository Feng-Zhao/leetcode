package test;

import java.util.stream.IntStream;

public class Test_JZ_17_打印range {
    StringBuilder res;
    int count = 0, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public String printNumbers2(int n) {
        this.n = n;
        res = new StringBuilder(); // 数字字符串集
        num = new char[n]; // 定义长度为 n 的字符列表
        dfs(0); // 开启全排列递归
        res.deleteCharAt(res.length() - 1); // 删除最后多余的逗号
        return res.toString(); // 转化为字符串并返回
    }
    void dfs(int x) {
        if(x == n) { // 终止条件：已固定完所有位
            res.append(String.valueOf(num) + ","); // 拼接 num 并添加至 res 尾部，使用逗号隔开
            return;
        }
        for(char i : loop) { // 遍历 ‘0‘ - ’9‘
            num[x] = i; // 固定第 x 位为 i
            dfs(x + 1); // 开启固定第 x + 1 位
        }
    }


    public static void main(String[] args) {
        // for (int i : printNumbers(3)) {
        //     System.out.format("%d,",i);
        // }
        Test_JZ_17_打印range s = new Test_JZ_17_打印range();
        System.out.println(s.printNumbers2(3));
    }
    
}

// 去除开头多余 0 的实现方法
// class Solution {
//     StringBuilder res;
//     int nine = 0, count = 0, start, n;
//     char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
//     public String printNumbers(int n) {
//         this.n = n;
//         res = new StringBuilder();
//         num = new char[n];
//         start = n - 1; // 记录截取字符串的其实位置, 从 1 位开始
//         dfs(0);
//         res.deleteCharAt(res.length() - 1);
//         return res.toString();
//     }
//     // 广度优先, 从左向右以此填写每一位数字
//     void dfs(int x) {
//         if(x == n) {
//             String s = String.valueOf(num).substring(start); // 截取字符串
//             if(!s.equals("0")) res.append(s + ","); // 不要 '0'
//             if(n - start == nine) start--; // 如果尾9的位数 = n - start, 表示start应该向左移动一位
//             return;
//         }
//         for(char i : loop) {
//             if(i == '9') nine++; // 遇到9 则进位;
//             num[x] = i; // 固定第 x 位为 i
//             dfs(x + 1); // 递归固定第 x + 1 位
//         }
//         nine--;
//     }
// }

