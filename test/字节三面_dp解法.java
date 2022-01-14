package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 字节三面_dp解法 {
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
    private boolean check(int row, int col){
        if(row >= 0 && row < 4 && col >= 0 && col < 4) {
            return true;
        }
        return false;
    }

    // dp法 借助 辅助队列 记录每层情况
    public int psCount(int row, int col, int k) throws Exception {
        // 对 row col k 的简单参数验证
        if(k <= 0){
            return 0;
        }
        if(!check(row, col)){
            throw new Exception("输入 row col 不合法");
        }

        int[] dp = new int[k];
        dp[0] = 1;
        Queue<Node> queue = new LinkedList<>();
        for (int pos : pos2pos.get(row*4 + col)) {
            queue.offer(new Node(pos,1));
        }
        
        // todo 没写完 变成 bfs了
        for (int i = 1; i < dp.length; i++) {
            int size = queue.size();
            int count = 0;
            while(size > 0){
                Node n = queue.poll();
                count += n.count;
                for (int newPos : pos2pos.get(n.pos)) {
                    queue.offer(new Node(newPos,n.count));
                }
            }
            dp[i] = count;
        }
       return dp[k-1];
    }

    public static void main(String[] args) throws Exception {
        字节三面_dp解法 solution = new 字节三面_dp解法();
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

class Node{
    int pos;
    int count;
    // public Node(){
    //     this.pos = -1;
    // }
    public Node(int pos, int count){
        this.pos = pos;
        this.count = count;
    }
}