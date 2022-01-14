package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// 0   1   2   3
// 4   5   6   7
// 8   9   10  11
// 12  13  14  15

// todo 暂时能想到的需要优化的地方
// count做包装,每次传递给dfs, 使对象无状态以便支持多线程,或者直接按工具类的写法,全都提供静态方法,不再new object
// 初始化过程优化, pos2pos 表做成 static 的, 防止每次使用对象都要new一遍相同的转移表;
// 将 pos2pos 初始化 时的 4 和 check 中的 4 做为参数, 供用户设置, 这样更加抽象, 不限于 4*4 的码表

// 时间复杂度优化: 
// dp 暂时还没写完
// dp里加了一个辅助queue,记录上一次走到的 char 和走到这个char 有多少种选择
// 用队列来记录每层的情况;
// 后来我又想了想, 是否能把密码表看作有环连通图, 这样问题就转化为寻找图中给定节点为起点
// 路径长度为 k 的所有路径数. 
// 这样说不定可以在遍历可连接节点的时候累计count, 
// 不过这就又有点类似于dfs的搜索了. 关于图结构做的练习比较少,之前学的图相关的算法更多的是节点间的连通性/路径/加权最短路径这些,
// 和这个限制深度的问题不太一样
// 不知道能不能把时间复杂度降下来

// dfs回溯法穷举查找密码组合数;
public class 字节三面_密码表 {
    // todo
    int count = 0;

    // 转移表: int 型位置 --> int[] 型 可转移位置列表
    List<List<Integer>> pos2pos = new ArrayList<>(16);
    // 初始化 pos to pos 的连接
    {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                List<Integer> list = new ArrayList<>();
                // 检查并添加到list
                // 上
                if(check(i-2,j+1)) list.add((i-2)*4 + j+1);
                if(check(i-2,j-1)) list.add((i-2)*4 + j-1);
                // 下
                if(check(i+2,j+1)) list.add((i+2)*4 + j+1);
                if(check(i+2,j-1)) list.add((i+2)*4 + j-1);
                // 左
                if(check(i+1,j-2)) list.add((i+1)*4 + j-2);
                if(check(i-1,j-2)) list.add((i-1)*4 + j-2);
                // 右
                if(check(i+1,j+2)) list.add((i+1)*4 + j+2);
                if(check(i-1,j+2)) list.add((i-1)*4 + j+2);

                pos2pos.add(list);
            }
        }
        // System.out.println(pos2pos);
    }
    // 检查是否在[0-15]范围内
    boolean check(int row, int col){
        if(row >= 0 && row < 4 && col >= 0 && col < 4) return true;
        return false;
    }

    public int psCount(int row, int col, int k) throws Exception {
        // 对 row col k 的简单参数验证
        if(k <= 0){
            return 0;
        }
        if(!check(row, col)){
            throw new Exception("输入 row col 不合法");
        }
        // count 归零, 只能单线程, 为了参数列表方便先这么写, 多线程需要把这个count包装为对象传递
        count = 0;
        // 深度优先,每次待填写长度 - 1
        dfs(row*4 + col, k-1);
        return count;
    }

    private void dfs(int pos, int leftK){
        // 长度达到给定 k 时, 停止, count + 1;
        if(leftK <= 0){
            count++;
            return;
        }
        // 对当前位置的每种选择做dfs
        for (int nextPos : pos2pos.get(pos)) {
            // 末尾位置变更, 待填写长度 - 1
            dfs(nextPos,leftK - 1);
        }

    }


    public static void main(String[] args) throws Exception {
        字节三面_密码表 solution = new 字节三面_密码表();
        Scanner in = new Scanner(System.in);
        System.out.println("demo: 输入 row col k, 其中 row, col = [0-3], k >= 0 k < 20, dfs回溯法 20 以上会很慢了, 而且k太大会有int溢出的问题, row 位置输入-1结束;");
        while(in.hasNextInt()){
            int row = in.nextInt();
            if(row == -1){
                in.close();
                return;
            }
            int col = in.nextInt();
            int k = in.nextInt();
            System.out.println("密码总数为: " + solution.psCount(row, col, k));
            System.out.println("demo: 输入 row col k, 其中 row, col = [0-3], k >= 0 k < 20, dfs回溯法 20 以上会很慢了, 而且k太大会有int溢出的问题, row 位置输入-1结束;");
        }
        in.close();
    }
}
