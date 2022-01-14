package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test_JZ_32按层打印二叉树 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        boolean q1flag = true;
        TreeNode cur = null;
        while(!queue1.isEmpty() || !queue2.isEmpty()){
            List<Integer> line = new ArrayList<>();
            if(q1flag){
                while (!queue1.isEmpty()){
                    cur = queue1.poll();
                    line.add(cur.val);
                    if(cur.left != null) queue2.offer(cur.left);
                    if(cur.right != null) queue2.offer(cur.right);
                }
                q1flag = false;
            }
            else{
                while (!queue2.isEmpty()){
                    cur = queue2.poll();
                    line.add(cur.val);
                    if(cur.left != null) queue1.offer(cur.left);
                    if(cur.right != null) queue1.offer(cur.right);
                }
                q1flag = true;
            }
            result.add(line);
        }
        return result;
    }


    public static void main(String[] args) {
        Test_JZ_32按层打印二叉树 solution = new Test_JZ_32按层打印二叉树();
        int[] tree = {3,9,20,23,11,15,7};
        TreeNode root = TreeUitl.buildTree(tree);
        List<List<Integer>> result = solution.levelOrder(root);
        for (List<Integer> list : result) {
            for (Integer i: list) {
                System.out.format("%d,",i);
            }
            System.out.print("\r\n");
        }
    }
}
